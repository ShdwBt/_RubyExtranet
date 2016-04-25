package com.rubyExtranet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model; // rajouté à la main !!! https://www.youtube.com/watch?v=kttfBthzIPI GURU tuto

import com.rubyExtranet.service.user.UserService;

@Controller
public class UsersController {
	
	private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }
	
    //Working of course
	@RequestMapping("/usersString")
	public String getUsersPageString(){
		return "users";
	}
	
	//Working
	@RequestMapping("/usersModelAndView")
	public ModelAndView getUsersPageModel(){
		return new ModelAndView("usersModelAndView", "users", userService.getAllUsers());
	}
	
	//Working
	@RequestMapping(value = "/usersBestModelAndView")
	public ModelAndView getusersPageBestModel(ModelAndView model){
		model.addObject("users", userService.getAllUsers()); 
		model.setViewName("usersBestModelAndView");
		return model;
	}
	
	//GURU tuto https://www.youtube.com/watch?v=kttfBthzIPI GURU tuto
	//Working
	@RequestMapping("/usersSimpleModel")
	public String getusersPageSimpleModel(Model model){
		model.addAttribute("users", userService.getAllUsers());
		return "usersSimpleModel";
	}
}
