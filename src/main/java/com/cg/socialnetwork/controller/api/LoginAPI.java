package com.cg.socialnetwork.controller.api;


import com.cg.socialnetwork.exception.DataInputException;
import com.cg.socialnetwork.exception.EmailExistsException;
import com.cg.socialnetwork.model.Media;
import com.cg.socialnetwork.model.User;
//import com.cg.socialnetwork.model.dto.UserDTO;

import com.cg.socialnetwork.model.dto.UserDTO;
import com.cg.socialnetwork.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Optional;

@RestController
@RequestMapping("api/login")
public class LoginAPI {

    @Autowired
    private IUserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO) throws ParseException {
        Optional<User> userOptional = userService.findByEmail(userDTO.getEmail());
        if (userOptional.isPresent()){
            throw new EmailExistsException("Email is exist!");
        }else{
            if(userDTO.checkEqual()){
                User user = userDTO.toUserSignUp();
                user.setAvatar(new Media(1));
                userService.save(user);
                return new ResponseEntity<>(HttpStatus.OK);
            }else{
                throw new DataInputException("reptype password is not equal");
            }
        }
    }


}