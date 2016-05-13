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

import com.rubyExtranet.model.user.EnumRole;
import com.rubyExtranet.model.user.State;
import com.rubyExtranet.model.user.User;
import com.rubyExtranet.model.user.UserCreateForm;
import com.rubyExtranet.model.user.UserUpdateForm;
import com.rubyExtranet.repository.UserRepository;
import com.rubyExtranet.service.user.UserService;


@Controller
public class UserManagerController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
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
	
	
//	@ModelAttribute("roles")
//	public Role[] roles() {
//		return Role.values();
//	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/userCreate", method = RequestMethod.GET)
	public ModelAndView getUserCreatePage(ModelAndView model){
		UserCreateForm userCreateForm = new UserCreateForm();
		model.addObject("form", userCreateForm);
		model.addObject("roles", EnumRole.values());
		model.addObject("states", State.values());
		model.setViewName("userCreate");
		return model;
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/userCreate", method = RequestMethod.POST)
	public ModelAndView handleUserCreateForm(ModelAndView model, @Valid @ModelAttribute("form") UserCreateForm form, BindingResult bindingResult){
//		if (bindingResult.hasErrors()) {
//			System.out.println("ERREUR");
////			UserCreateForm userCreateForm = new UserCreateForm();
////			model.addObject("form", userCreateForm);
////			model.addObject("roles", Role.values());
////			model.addObject("state", State.values());
//			getUserCreatePage(model);
//            return model;
//        }
        try {
            userService.create(form);
        } catch (DataIntegrityViolationException e) {
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
		model.addObject("states", State.values());
		model.setViewName("userUpdate");
		return model;
	}
	
//	@RequestMapping(value="/userUpdate{id}", method = RequestMethod.POST)
//	public ModelAndView handleUserUpdatePage(ModelAndView model,  @PathVariable Integer id, 
//			@Valid @ModelAttribute("form") UserUpdateForm form, BindingResult bindingResult, User user){
////		if (bindingResult.hasErrors()) {
////            return "userUpdate{id}";
////        }
////        try {
////            userService.updateUser(form);
////        } catch (DataIntegrityViolationException e) {
////            bindingResult.reject("email.exists", "Email already exists");
////            return "userCreate";
////        }
////        return "redirect:/usersList";        
//		
//		userService.updateUser(form);
//		
//		//userService.updateUserv3(form.getFirstName(), form.getLastName(), form.getEmail(),user.getId(), user);
//		
//		model.setViewName("redirect:/usersList");
//		return model;
//	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/userUpdate{id}", method = RequestMethod.POST)
	public ModelAndView handleUserUpdatePage(ModelAndView model,  @PathVariable Integer id, 
			@Valid @ModelAttribute("form") UserUpdateForm form, BindingResult bindingResult, User user){
		user.setPassword(userService.getUserById(id).get().getPassword());
		//user.setRole(userService.getUserById(id).get().getRole()); // if we remove the admin updating roles power
		user.setRole(form.getRole());
		userRepository.save(user);
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
