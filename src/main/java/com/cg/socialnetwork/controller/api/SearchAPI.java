package com.cg.socialnetwork.controller.api;

import com.cg.socialnetwork.model.User;
import com.cg.socialnetwork.model.dto.SearchDTO;
import com.cg.socialnetwork.service.User.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/search")
public class SearchAPI {

    @Autowired
    private IUserService userService;

    @PostMapping("/list")
    public ResponseEntity<?> getList(@RequestParam("keyword") String keyword){
//        keyword = "%" + keyword + "%";
        Iterable<SearchDTO> searchDTOS = userService.findByNameContaining(keyword);
        return new ResponseEntity<>( searchDTOS, HttpStatus.OK);
    }
}
