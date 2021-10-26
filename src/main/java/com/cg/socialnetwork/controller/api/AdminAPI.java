package com.cg.socialnetwork.controller.api;

import com.cg.socialnetwork.exception.DataInputException;
import com.cg.socialnetwork.exception.EmailExistsException;
import com.cg.socialnetwork.model.JwtResponse;
import com.cg.socialnetwork.model.Media;
import com.cg.socialnetwork.model.Role;
import com.cg.socialnetwork.model.User;
import com.cg.socialnetwork.model.dto.UserDTO;

import com.cg.socialnetwork.model.enumModel.Gender;
import com.cg.socialnetwork.service.jwt.JwtService;
import com.cg.socialnetwork.service.role.RoleService;
import com.cg.socialnetwork.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;


import java.text.ParseException;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class AdminAPI {


    @Autowired
    private com.cg.socialnetwork.service.user.IUserService userService;

    @GetMapping("/userList")
    public ResponseEntity<?> userList(){
        Iterable<UserDTO> userDTOS = userService.userList();
        return new ResponseEntity<>(userDTOS,HttpStatus.OK);
    }

    @Autowired
    private RoleService roleService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO) throws ParseException {
        Optional<User> userOptional = userService.findByEmail(userDTO.getEmail());
        if (userOptional.isPresent()){
            throw new EmailExistsException("Email is exist!");
        }else{
            if(userDTO.checkEqual()){
                User user = userDTO.toUserSignUp();
                if (userDTO.getGender() == Gender.M) {
                    user.setAvatar(new Media(2));
                }
                if (userDTO.getGender() == Gender.F) {
                    user.setAvatar(new Media(3));
                }
                user.setBackground(new Media(1));
                user.setRole(new Role(new Long(1) ));

                userService.save(user);

                return new ResponseEntity<>(HttpStatus.CREATED);

            }else{
                throw new DataInputException("reptype password is not equal");
            }
        }
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDTO.getEmail(), userDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User currentUser = userService.findByEmail(userDTO.getEmail()).get();

        JwtResponse jwtResponse = new JwtResponse(
                jwt,
                currentUser.getId(),
                userDetails.getUsername(),
                currentUser.getEmail(),
                userDetails.getAuthorities()
        );

        ResponseCookie springCookie = ResponseCookie.from("JWT", jwt)
                .httpOnly(false)
                .secure(false)
                .path("/")
                .maxAge(60 * 1000)
//                .domain("spb-bank-transaction-jwt.herokuapp.com")
//                .domain("bank-transaction.azurewebsites.net")
                .domain("localhost")
                .build();
        System.out.println(jwtResponse);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.SET_COOKIE, springCookie.toString())
                .body(jwtResponse);


    }


    @PostMapping("/setLock/{id}")
    public ResponseEntity<?> setLock(@PathVariable Long id) {
        Optional<User> userOptional = userService.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setStatus(user.getStatus() ? false : true);
            userService.save(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


