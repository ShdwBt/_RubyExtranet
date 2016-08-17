package com.rubyExtranet.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rubyExtranet.model.user.EnumDepartment;
import com.rubyExtranet.model.user.EnumRole;
import com.rubyExtranet.model.user.EnumState;
import com.rubyExtranet.model.user.UserCreateForm;
import com.rubyExtranet.model.user.UserUpdateForm;
import com.rubyExtranet.repository.DepartmentRepository;
import com.rubyExtranet.repository.RoleRepository;
import com.rubyExtranet.repository.UserRepository;
import com.rubyExtranet.service.user.UserService;


@Controller
public class UserManagerController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	public UserManagerController(UserService userService, UserRepository userRepository) {
		super();
		this.userService = userService;
		this.userRepository = userRepository;
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/usersList", method = RequestMethod.GET)
	public ModelAndView getUsersListPage(ModelAndView model){
		model.addObject("users", userService.getAllUsers());
		model.setViewName("usersList");
		return model;
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/user{id}", method = RequestMethod.GET)
	public ModelAndView getUserPage(ModelAndView model, @PathVariable Integer id){
		model.addObject("user", userService.getUserById(id).get());
		model.setViewName("user");
		return model;
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/userCreate", method = RequestMethod.GET)
	public ModelAndView getUserCreatePage(ModelAndView model){
		UserCreateForm userCreateForm = new UserCreateForm();
		model.addObject("form", userCreateForm);
		model.addObject("roles", userService.getAllRole());
		model.addObject("states", EnumState.values());
		
//		model.addObject("departments", userService.getAllDepartments());
		model.addObject("departments", EnumDepartment.values());
		//model.addObject("departments", department.getDepartment());
		model.setViewName("userCreate");
		return model;
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/userCreate", method = RequestMethod.POST)
	public ModelAndView handleUserCreateForm(ModelAndView model, 
			@Valid @ModelAttribute("form") UserCreateForm form, 
			BindingResult bindingResult){	
		try {
            userService.create(form);
        } 
		catch (DataIntegrityViolationException e) {
            bindingResult.reject("email.exists", "Email already exists");
            model.setViewName("home");
            return model;
        }
        model.setViewName("redirect:/usersList");
        return model;
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/userUpdate{id}", method = RequestMethod.GET)
	public ModelAndView getUserUpdatePage(ModelAndView model, @PathVariable Integer id){
		UserUpdateForm userUpdateForm = new UserUpdateForm();
		model.addObject("form", userUpdateForm);
		model.addObject("user" , userService.getUserById(id).get());
		model.addObject("roles", EnumRole.values());
		model.addObject("states", EnumState.values());
		model.addObject("departments", userService.getAllDepartments()); 
		model.setViewName("userUpdate");
		return model;
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/userUpdate{id}", method = RequestMethod.POST)
	public ModelAndView handleUserUpdatePage(ModelAndView model,
			@PathVariable Integer id, 
			@Valid @ModelAttribute("form") UserUpdateForm form, 
			BindingResult bindingResult){
		userService.updateUser(form, id);
        model.setViewName("redirect:/usersList");
        return model;
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value= "/userDelete{id}")
	public ModelAndView getUserDeletePage(ModelAndView model, @PathVariable Integer id){
		System.out.println(id);
		userService.deleteUser(id);
		model.setViewName("redirect:/usersList");
		return model;
	}

}
