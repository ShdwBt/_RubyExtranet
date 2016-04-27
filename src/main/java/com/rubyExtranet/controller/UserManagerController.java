package com.rubyExtranet.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rubyExtranet.model.user.UserCreateForm;
import com.rubyExtranet.service.user.UserService;

@Controller
public class UserManagerController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	public UserManagerController(UserService userService) {
		super();
		this.userService = userService;
	}
	

	
	
	@RequestMapping(value="/usersList", method = RequestMethod.GET)
	public ModelAndView getUsersListPage(ModelAndView model){
		model.addObject("users", userService.getAllUsers());
		model.setViewName("usersList");
		return model;
	}
	
	@RequestMapping(value="/user", method = RequestMethod.GET)
	public ModelAndView getUserPage(ModelAndView model, @PathVariable Integer id){
		model.addObject("users", userService.getUserById(id));
		model.setViewName("user");
		return model;
	}
	
	
	
	@RequestMapping(value="/userCreate", method = RequestMethod.GET)
	public ModelAndView getUserCreatePage(ModelAndView model){
		UserCreateForm userCreateForm = new UserCreateForm();
		model.addObject("form", userCreateForm);
		model.addObject("role",userCreateForm.getRole());
		model.addObject("state", userCreateForm.getState());
		model.setViewName("userCreate");
		return model;
	}
	
	@RequestMapping(value="/userCreate", method = RequestMethod.POST)
	public String handleUserCreateForm(ModelAndView model,@Valid @ModelAttribute("form") UserCreateForm form, BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
            return "userCreate";
        }
        try {
            userService.create(form);
        } catch (DataIntegrityViolationException e) {
            bindingResult.reject("email.exists", "Email already exists");
            return "userCreate";
        }
        return "redirect:/usersList";
	}
	
	@RequestMapping(value="/userUpdate{id}", method = RequestMethod.GET)
	public ModelAndView getUserUpdatePage(ModelAndView model, @PathVariable Integer id){
		model.addObject("user" , userService.getUserById(id));
		UserCreateForm userCreateForm = new UserCreateForm();
		model.addObject("form", userCreateForm);
		model.setViewName("userUpdate");
		return model;
	}

	
	
}
