package com.cg.socialnetwork.controller.api;

import com.cg.socialnetwork.exception.DataInputException;
import com.cg.socialnetwork.exception.EmailExistsException;
import com.cg.socialnetwork.model.Media;
import com.cg.socialnetwork.model.User;
import com.cg.socialnetwork.model.dto.UserDTO;

import com.cg.socialnetwork.model.enumModel.Gender;
import com.cg.socialnetwork.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
                userService.save(user);
                return new ResponseEntity<>(userService.findByEmail(userDTO.getEmail()).get().toUserDTOAdmin(), HttpStatus.OK);
            }else{
                throw new DataInputException("reptype password is not equal");
            }
        }
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
