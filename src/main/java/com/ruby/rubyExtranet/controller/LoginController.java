package com.ruby.rubyExtranet.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@RequestMapping(value = "/extranetLogin", method = RequestMethod.GET)
    public ModelAndView getLextranetLoginPage(@RequestParam Optional<String> error, ModelAndView model) {
        System.out.println("Page de Login");
        model.setViewName("extranetLogin");
		return model;
    }
	
	
	@RequestMapping(value = "/extranetLogin", method = RequestMethod.POST)
    public ModelAndView handleextranetLoginPage(ModelAndView model) {
		model.setViewName("redirect:/connect");
		return model;
    }
	
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/connect", method = RequestMethod.GET)
    public String handleConnect() {
		return "connect";
    }
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public ModelAndView logoutPage (ModelAndView model, HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    model.setViewName("extranetLogin");
	    return model;
	}
}
