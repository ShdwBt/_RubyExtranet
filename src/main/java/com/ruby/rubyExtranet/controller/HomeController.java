package com.ruby.rubyExtranet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping(value = {"/", "/home" })
    public ModelAndView getHomePage(ModelAndView model) {
		model.setViewName("/home");
        return model;
    }
	
}
