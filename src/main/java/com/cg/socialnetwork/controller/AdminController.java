package com.cg.socialnetwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private com.cg.socialnetwork.service.user.IUserService userService;

    @GetMapping("")
    public ModelAndView adminDashboard(){
        return new ModelAndView("admin/admin");
    }
}
