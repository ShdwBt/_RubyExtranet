package com.rubyExtranet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rubyExtranet.service.UserService;

@Controller
public class UsersController {
	
	private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }
	
	@RequestMapping("/usersString")
	public String getUsersPageString(){
		return "users";
	}
	
	@RequestMapping("/usersModel")
	public ModelAndView getUsersPageModel(){
		return new ModelAndView("users", "users", userService.getAllUsers());
	}
	
}
