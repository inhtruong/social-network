package com.cg.socialnetwork.controller.api;


import com.cg.socialnetwork.model.Friend;

import com.cg.socialnetwork.service.friend.IFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/friend")
public class FriendAPI {

    @Autowired
    public IFriendService friendService;

    @GetMapping
    public ResponseEntity<Iterable<?>> findAllFriend(){

        try {
            Iterable<Friend> friends = friendService.findAll();
            if( ((List) friends).isEmpty()){
                return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(friends, HttpStatus.OK);
        }catch (Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Friend> findFriendById(@PathVariable long id ){
        Optional<Friend> friendOptional = friendService.findById(id);
        if (!friendOptional.isPresent()){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(friendOptional.get(),HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public  ResponseEntity<Friend> updateFriend(@PathVariable long id , @RequestBody Friend friend){
        Optional<Friend> friendOptional = friendService.findById(id);
        if (!friendOptional.isPresent()){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(friendService.save(friend),HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Friend> createFriend(@RequestBody Friend friend){
        return new ResponseEntity<>(friendService.save(friend),HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public  ResponseEntity<Friend> deleteFriend(@PathVariable long id ){
        Optional<Friend> friendOptional = friendService.findById(id);
        if (!friendOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        friendService.deleteById(id);
        return new ResponseEntity<>(friendOptional.get(),HttpStatus.NO_CONTENT);
    }

}