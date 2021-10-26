package com.cg.socialnetwork.controller;

import com.cg.socialnetwork.model.JwtResponse;
import com.cg.socialnetwork.model.User;
import com.cg.socialnetwork.model.dto.UserDTO;
import com.cg.socialnetwork.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/social")
public class SocialController {

    @Autowired
    private IUserService userService;


    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
//        System.out.println("userName: " + userName);
        return userName;
    }

    @GetMapping
    public ModelAndView getHome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index");
        Optional<User> userOptional = userService.findByEmail(getPrincipal());
//        Optional<User> user = userService.findById(userOptional.get().getId())
        if(userOptional == null){
            modelAndView.setViewName("error");
        }else{
            modelAndView.addObject("user", userOptional.get());
        }
        return modelAndView;
    }

//    @GetMapping("/{id}")
//    public ModelAndView showUser(@PathVariable long id){
//
//        Optional<User> user = userService.findById(id);
//        Optional<UserDTO> userDTO = userService.findByIdDTO(id);
//        if (!user.isPresent()){
//            return new ModelAndView("/error");
//        }
//        ModelAndView modelAndView = new ModelAndView("/profile");
//        modelAndView.addObject("user",user);
//        modelAndView.addObject("userDTO", userDTO);
//        return modelAndView;
//    }
}
