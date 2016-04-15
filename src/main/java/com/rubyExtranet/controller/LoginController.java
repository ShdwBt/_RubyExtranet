package com.rubyExtranet.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage(@RequestParam Optional<String> error, ModelAndView model) {
        model.addObject("error", error);
        model.setViewName("login");
		return model;
    }
	
	
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String handleLoginPage(@RequestParam String email, ModelAndView model) {
//        model.addObject("name", email);
//        model.setViewName("greeting");
//		return "redirect:/greeting";
//    }
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView handleLoginPage(ModelAndView model) {
		model.setViewName("redirect:/connect");
		return model;
    }
	
	@RequestMapping(value = "/loginDesign", method = RequestMethod.GET)
    public ModelAndView getLoginDesignPage(@RequestParam Optional<String> error, ModelAndView model) {
        model.addObject("error", error);
        System.out.println("1.2.3.");
        model.setViewName("loginDesign");
		return model;
    }
	
	@RequestMapping(value = "/loginDesign", method = RequestMethod.POST)
    public ModelAndView handleLoginDesignPage(ModelAndView model) {
		model.setViewName("redirect:/connect");
		return model;
    }
	@RequestMapping(value = "/connect", method = RequestMethod.GET)
    public String handleConnect() {
		return "connect";
    }
}
