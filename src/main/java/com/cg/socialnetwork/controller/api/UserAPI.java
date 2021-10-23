package com.cg.socialnetwork.controller.api;//package com.cg.controller.api;



import com.cg.socialnetwork.exception.DataInputException;
import com.cg.socialnetwork.model.User;
import com.cg.socialnetwork.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserAPI {

    @Autowired
    private IUserService userService;

    @GetMapping
    public ResponseEntity<Iterable<?>> findAllUser() {
        try {
            Iterable<User> users = userService.findAll();

            if (((List) users).isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable long id) {
        Optional<User> user = userService.findById(id);
//  c1      return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));\
        if (!user.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(user.get(),HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user){
        Optional<User> userOptional = userService.findById(id);
        if(!userOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(userOptional.get(),HttpStatus.OK);
        }
    }

    @PostMapping("/suspend/{id}")
    public ResponseEntity<?> doSuspend(@PathVariable long id) {
        Optional<User> user = userService.findById(id);

        if (user.isPresent()) {
            try {

                userService.save(user.get());

                return new ResponseEntity<>(HttpStatus.CREATED);
            } catch (DataIntegrityViolationException e) {
                throw new DataInputException("Invalid suspension information");
            }
        } else {
            throw new DataInputException("Invalid customer information");
        }
    }
    //    @PostMapping
//    public ResponseEntity<?> createCustomer(@Validated @RequestBody  userDTO, BindingResult bindingResult) {
//        if (bindingResult.hasErrors())
//            return appUtils.mapErrorToResponse(bindingResult);
//
//        Optional<User> optUser = userService.findByEmail(userDTO.getEmail());
//
//        if (optCustomer.isPresent()) {
//            throw new EmailExistsException("Email already exists");
//        }

//        try {
//            return new ResponseEntity<>(userService.save(userDTO.toUser()), HttpStatus.CREATED);

//        } catch (DataIntegrityViolationException e) {
//            throw new DataInputException("Invalid customer creation information");
//        }

    }



