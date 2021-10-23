package com.cg.socialnetwork.controller;

import com.cg.socialnetwork.model.User;
import com.cg.socialnetwork.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    com.cg.socialnetwork.service.user.IUserService userService;

    @GetMapping
    public ModelAndView getLogin(){
        return new ModelAndView("login","user", new UserDTO());
    }

    @PostMapping
    public ModelAndView login(@ModelAttribute("user") UserDTO userDTO, HttpSession session){
        ModelAndView modelAndView = new ModelAndView("login");
        Optional<User> userOptional = userService.findByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword());
        System.out.println(userOptional.get());
        if (userOptional.isPresent()){
            if(userOptional.get().getStatus()){
                session.setAttribute("account", userOptional.get());
                return new ModelAndView("redirect:/social");
            }else{
                modelAndView.addObject("mess","This user is Locked");
            }
        }{
            modelAndView.addObject("mess","Email or password is wrong !");
        }
        return modelAndView;
    }

    @PostMapping("/logout")
    public ModelAndView logout(HttpSession session){
        session.removeAttribute("account");
        return new ModelAndView("redirect:/login");
    }
}
