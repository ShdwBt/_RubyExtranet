package com.rubyExtranet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rubyExtranet.model.UserCreateForm;

@Controller
public class UserController {
	@RequestMapping("/user")
	public String User(){
		return "user";
	}
	
	@RequestMapping("/user/createSimple")
	public String getUserCreatePage(){
		return "userCreateSimple";
	}
	
	@RequestMapping("/user/createWithForm")
	public ModelAndView getUserCreateWithFormPage(ModelAndView model){
		UserCreateForm userCreateForm = new UserCreateForm();
		model.addObject("form", userCreateForm);
		model.addObject("role",userCreateForm.getRole());
		model.addObject("state", userCreateForm.getState());
		model.setViewName("userCreateWithForm");
		return model;
	}
}
