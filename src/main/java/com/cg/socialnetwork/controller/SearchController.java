package com.cg.socialnetwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/search")
public class SearchController {

//    @GetMapping()
//    public String getSearch() {
//        return "search";
//    }

    @GetMapping()
    public ModelAndView search(@RequestParam("keyword") String keyword){
        if (keyword == null) keyword = "";
        return new ModelAndView("/search", "keyword", keyword);
    }
}
