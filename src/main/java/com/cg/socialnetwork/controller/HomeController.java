package com.cg.socialnetwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class HomeController {
    @GetMapping("/")
    public String showIndex() {
        return "redirect:/social";
    }


    @GetMapping("/login")
    public ModelAndView redirected(){
        return new ModelAndView("login");
    }

}

