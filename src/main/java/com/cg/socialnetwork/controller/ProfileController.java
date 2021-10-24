package com.cg.socialnetwork.controller;

import com.cg.socialnetwork.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/profile/{id}")
public class ProfileController {
    @Autowired
    private com.cg.socialnetwork.service.user.IUserService userService;

    @GetMapping
    public ModelAndView showUser(@PathVariable long id){

        Optional<User> newUser = userService.findById(id);
        if (!newUser.isPresent()){
            return new ModelAndView("/error");
        }
        ModelAndView modelAndView = new ModelAndView("/profile");
        modelAndView.addObject("user",newUser);
        return modelAndView;
    }
}
