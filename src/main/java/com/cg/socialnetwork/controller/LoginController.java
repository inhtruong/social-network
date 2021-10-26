//package com.cg.socialnetwork.controller;
//
//import com.cg.socialnetwork.model.JwtResponse;
//import com.cg.socialnetwork.model.User;
//import com.cg.socialnetwork.model.dto.UserDTO;
//import com.cg.socialnetwork.service.jwt.JwtService;
//import com.cg.socialnetwork.service.role.IRoleService;
//import com.cg.socialnetwork.service.user.IUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.ResponseCookie;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpSession;
//import java.util.Optional;
//
//@Controller
//@RequestMapping("/login")
//public class LoginController {
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private JwtService jwtService;
//
//    @Autowired
//    private IUserService userService;
//
//    @Autowired
//    private IRoleService roleService;
//
//    @GetMapping
//    public ModelAndView getLogin(){
//        return new ModelAndView("login","user", new UserDTO());
//    }
//
////    @PostMapping
////    public ModelAndView login(@ModelAttribute("user") UserDTO userDTO, HttpSession session){
////        ModelAndView modelAndView = new ModelAndView("login");
////        Optional<User> userOptional = userService.findByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword());
////        System.out.println(userOptional.get());
////        if (userOptional.isPresent()){
////            if(userOptional.get().getStatus()){
////                session.setAttribute("account", userOptional.get());
////                return new ModelAndView("redirect:/social");
////            }else{
////                modelAndView.addObject("mess","This user is Locked");
////            }
////        }{
////            modelAndView.addObject("mess","Email or password is wrong !");
////        }
////        return modelAndView;
////    }
//
//    @PostMapping
//    public ResponseEntity<?> login(@RequestBody User user) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        String jwt = jwtService.generateTokenLogin(authentication);
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//        User currentUser = userService.findByEmail(user.getEmail()).get();
//
//        JwtResponse jwtResponse = new JwtResponse(
//                jwt,
//                currentUser.getId(),
//                userDetails.getUsername(),
//                currentUser.getEmail(),
//                userDetails.getAuthorities()
//        );
//
//        ResponseCookie springCookie = ResponseCookie.from("JWT", jwt)
//                .httpOnly(false)
//                .secure(false)
//                .path("/")
//                .maxAge(60 * 1000)
////                .domain("spb-bank-transaction-jwt.herokuapp.com")
////                .domain("bank-transaction.azurewebsites.net")
//                .domain("localhost")
//                .build();
//
//        System.out.println(jwtResponse);
//
//        return ResponseEntity
//                .ok()
//                .header(HttpHeaders.SET_COOKIE, springCookie.toString())
//                .body(jwtResponse);
//
//
//    }
//
////    @PostMapping("/logout")
////    public ModelAndView logout(HttpSession session){
////        session.removeAttribute("account");
////        return new ModelAndView("redirect:/login");
////    }
//}
