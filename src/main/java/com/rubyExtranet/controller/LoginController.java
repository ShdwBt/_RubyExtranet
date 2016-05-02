package com.rubyExtranet.controller;

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
	
	//@PreAuthorize("hasAnyAuthority('ADMIN', 'USER', 'DBA')")
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
	    model.setViewName("loginDesign");
	    return model;
	}
}
