//package com.rubyExtranet.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.rubyExtranet.model.user.User;
//import com.rubyExtranet.service.user.UserService;
//
//@Controller
//public class UserManagerControllerOrigin {
//	
//	@Autowired
//	UserService service;
//	
//	
////    @RequestMapping(value = { "/editUser-{id}" }, method = RequestMethod.GET)
////    public String editUser(@PathVariable int id, ModelMap model) {
////        User user  = service.findById(id);
////        model.addAttribute("user", user);
////        //model.addAttribute("edit", true); pour réutiliser le même form que celui de création
////        return "usersBestModelAndView";
////    }
//    
//    @RequestMapping(value = { "/editUser" }, method = RequestMethod.GET)
//    public ModelAndView editUser(ModelAndView model, @RequestParam int id){//, @PathVariable int id, ) {
//        User user  = service.findById(id);
//        model.addObject("user", user);
//        model.setViewName("usersBestModelAndView");
//        //model.addAttribute("edit", true); pour réutiliser le même form que celui de création
//        return model;
//    }
//    
////    @RequestMapping(value = { "/editUser-{id}" }, method = RequestMethod.POST)
////    public String updateUser(User user, ModelMap model, @PathVariable int id) {
////        service.updateUser(user);
////        return "usersBestModelAndView";
////    }
//    
//    @RequestMapping(value = { "/editUser-{id}" }, method = RequestMethod.POST)
//    public ModelAndView updateUser(User user, ModelAndView model, @PathVariable int id) {
//        service.updateUser(user);
//        model.setViewName("usersBestModelAndView");
//        return model;
//    }
//    
//    @RequestMapping(value = { "/delete-user-{id}" }, method = RequestMethod.GET)
//    public String deleteUser(@PathVariable int id) {
//        service.deleteUser(id);
//        return "redirect:/usersBestModelAndView";
//    }
//}
