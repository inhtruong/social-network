package com.cg.socialnetwork.controller;

import com.cg.socialnetwork.model.User;
import com.cg.socialnetwork.model.dto.UserDTO;
import com.cg.socialnetwork.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/profiles")
public class ProController {
    @Autowired
    private IUserService userService;

    @GetMapping("/{id}")
    public ModelAndView showUser(@PathVariable Long id){

        Optional<User> user = userService.findById(id);

        if (!user.isPresent()){
            return new ModelAndView("/error");
        }
        ModelAndView modelAndView = new ModelAndView("profile");
        modelAndView.addObject("user",user.get());
        return modelAndView;
    }
}
