package com.rubyExtranet.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rubyExtranet.model.user.UserCreateForm;
import com.rubyExtranet.model.user.UserCreateFormValidator;
import com.rubyExtranet.service.user.UserService;


@Controller
public class UserController {
	
	private final UserService userService;
	//private final UserCreateFormValidator userCreateFormValidator;
	
	@Autowired
    public UserController(UserService userService){//, UserCreateFormValidator userCreateFormValidator) {
        this.userService = userService;
        //this.userCreateFormValidator = userCreateFormValidator;
    }
	
//	@InitBinder("form")
//    public void initBinder(WebDataBinder binder) {
//        binder.addValidators(userCreateFormValidator);
//    }
	
	
	@RequestMapping(value="/userCreateWithForm", method = RequestMethod.GET)
	public ModelAndView getUserCreateWithFormPage(ModelAndView model){
		UserCreateForm userCreateForm = new UserCreateForm();
		model.addObject("form", userCreateForm);
		model.addObject("role",userCreateForm.getRole());
		model.addObject("state", userCreateForm.getState());
		model.setViewName("userCreateWithForm");
		return model;
	}
	
	@RequestMapping(value="/userCreateWithForm", method = RequestMethod.POST)
	public String handleUserCreateForm(ModelAndView model,@Valid @ModelAttribute("form") UserCreateForm form, BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
            return "userCreateWithForm";
        }
        try {
            userService.create(form);
        } catch (DataIntegrityViolationException e) {
            bindingResult.reject("email.exists", "Email already exists");
            return "userCreateWithForm";
        }
        return "redirect:/usersBestModelAndView";
		
	}

}
