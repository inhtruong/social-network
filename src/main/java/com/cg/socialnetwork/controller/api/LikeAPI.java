package com.cg.socialnetwork.controller.api;

import com.cg.socialnetwork.model.Like;
import com.cg.socialnetwork.model.dto.LikeDTO;
import com.cg.socialnetwork.service.like.ILikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/likes")
public class LikeAPI {

    @Autowired
    private ILikeService iLikeService;

    @GetMapping
    public ResponseEntity<LikeDTO> getAllLike(){
        try {
            Optional<LikeDTO> likes = iLikeService.findAllTest();

            if (!likes.isPresent()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return  new ResponseEntity<>(likes.get(),HttpStatus.OK);
        }catch (Exception e) {
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping({"/id"})
    public ResponseEntity<Like> findLikeById(@PathVariable long id){
        Optional<Like> likeOptional = iLikeService.findById(id);
        if (!likeOptional.isPresent()){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(likeOptional.get(),HttpStatus.OK);

    }

    @PutMapping({"/id"})
    public ResponseEntity<Like> updateLike(@PathVariable long id , @RequestBody Like like){
        Optional<Like> likeOptional = iLikeService.findById(id);
        if (!likeOptional.isPresent()){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(likeOptional.get(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Like> createLike(@RequestBody Like like){
        return new ResponseEntity<>(iLikeService.save(like),HttpStatus.CREATED);
    }

    @DeleteMapping({"/id"})
    public ResponseEntity<Like> deleteLike(@PathVariable long id ){
        Optional<Like> likeOptional = iLikeService.findById(id);
        if (!likeOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iLikeService.deleteById(id);
        return new ResponseEntity<>(likeOptional.get(), HttpStatus.NO_CONTENT);
    }


}
