
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
@RequestMapping("/profile/{id}")
public class ProfileController {
    @Autowired
    private IUserService userService;

    @GetMapping
    public ModelAndView showUser(@PathVariable long id){

        Optional<User> user = userService.findById(id);
        Optional<UserDTO> userDTO = userService.findByIdDTO(id);
        if (!user.isPresent()){
            return new ModelAndView("/error");
        }
        ModelAndView modelAndView = new ModelAndView("/profile");
        modelAndView.addObject("user",user);
        modelAndView.addObject("userDTO", userDTO);
        return modelAndView;
    }
}

