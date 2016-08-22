package com.ruby.rubyBrandbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BrandbookController {
	@RequestMapping(value = "/brandbook")
    public ModelAndView getBrandBookPage(ModelAndView model) {
		model.setViewName("/brandbook");
        return model;
    }
}
