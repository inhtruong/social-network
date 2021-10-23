package com.cg.socialnetwork.controller.api;

import com.cg.socialnetwork.model.Comment;
import com.cg.socialnetwork.service.comment.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class CommentAPI {

    @Autowired
    private ICommentService commentService;

    @GetMapping
    public ResponseEntity<Iterable<?>> findAllComment(){
        try{
            Iterable<Comment> comments = commentService.findAll();
            if(((List) comments).isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(comments,HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> findById(@PathVariable long id){
        Optional<Comment> commentOptional = commentService.findById(id);
        if(!commentOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> updatePost(@PathVariable long id, @RequestBody Comment comment){
        Optional<Comment> commentOptional = commentService.findById(id);
        if(!commentOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        comment.setId(commentOptional.get().getId());
        return new ResponseEntity<>(commentService.save(comment),HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Comment> createPost(@RequestBody Comment comment){
        return new ResponseEntity<>(commentService.save(comment),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Comment> deletePost(@PathVariable long id){
        Optional<Comment> postOptional = commentService.findById(id);
        if(!postOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
//        postService.deleteById(id);
        return new ResponseEntity<>(postOptional.get(),HttpStatus.NO_CONTENT);
    }
}
