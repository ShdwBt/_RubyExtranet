package com.rubyExtranet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rubyExtranet.model.user.User;
import com.rubyExtranet.service.user.UserService;

@Controller
public class UserManagerController {
	
	@Autowired
	UserService service;
	
	
    @RequestMapping(value = { "/edit-user-{id}" }, method = RequestMethod.GET)
    public String editUser(@PathVariable int id, ModelMap model) {
        User user  = service.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        return "usersBestModelAndView";
    }
    
    @RequestMapping(value = { "/edit-user-{id}" }, method = RequestMethod.POST)
    public String updateUser(User user, ModelMap model, @PathVariable int id) {
        service.updateUser(user);
        return "usersBestModelAndView";
    }
    
    @RequestMapping(value = { "/delete-user-{id}" }, method = RequestMethod.GET)
    public String deleteUser(@PathVariable int id) {
        service.deleteUser(id);
        return "redirect:/usersBestModelAndView";
    }
}
