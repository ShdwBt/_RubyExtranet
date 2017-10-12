package com.ruby.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ShdwBt on 23/09/2017.
 */
@Controller
public class HomeController {
    @RequestMapping(value = {"/", "/home" })
    public ModelAndView getHomePage(ModelAndView model) {
        model.setViewName("/home");
        return model;
    }
}
