package com.cg.socialnetwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/social")
public class SocialController {
        @GetMapping
        public ModelAndView getHome() {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("/index");
            return modelAndView;
        }

}
