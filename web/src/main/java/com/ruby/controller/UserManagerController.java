package com.ruby.controller;

import com.ruby.form.UserCreationForm;
import com.ruby.form.UserUpdateForm;
import com.ruby.repository.DepartmentRepository;
import com.ruby.repository.RoleRepository;
import com.ruby.repository.StateRepository;
import com.ruby.repository.UserRepository;
import com.ruby.service.UserService;
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

import javax.validation.Valid;

/**
 * Created by ShdwBt on 23/09/2017.
 */
@Controller
public class UserManagerController {

    UserService             userService;
    UserRepository          userRepository;
    DepartmentRepository    departmentRepository;
    RoleRepository          roleRepository;
    StateRepository         stateRepository;

    @Autowired
    public UserManagerController(UserService userService, UserRepository userRepository,
                                 DepartmentRepository departmentRepository, RoleRepository roleRepository,
                                 StateRepository stateRepository) {
        super();
        this.userService = userService;
        this.userRepository = userRepository;
        this.departmentRepository = departmentRepository;
        this.stateRepository = stateRepository;
        this.roleRepository = roleRepository;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value="/usersList", method = RequestMethod.GET)
    public ModelAndView getUsersListPage(ModelAndView model){
        model.addObject("users", userService.getAll());
        model.setViewName("usersList");
        return model;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value="/user{id}", method = RequestMethod.GET)
    public ModelAndView getUserPage(ModelAndView model, @PathVariable Integer id){
        model.addObject("user", userService.getById(id).get());
        model.addObject("department", userService.getById(id).get().getDepartment().getText());
        model.setViewName("user");
        return model;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value="/userCreate", method = RequestMethod.GET)
    public ModelAndView getUserCreatePage(ModelAndView model){
        UserCreationForm userCreationForm = new UserCreationForm();

        model.addObject("form", userCreationForm);
        model.addObject("principalRole", roleRepository.findAll());
        model.addObject("additionalRole", roleRepository.findAll());
        model.addObject("states", stateRepository.findAll());
        model.addObject("departments", departmentRepository.findAll());
        model.setViewName("userCreate");

        return model;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value="/userCreate", method = RequestMethod.POST)
    public ModelAndView handleUserCreateForm(ModelAndView model,
                                             @Valid @ModelAttribute("form") UserCreationForm form,
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

        model.addObject("user" , userService.getById(id).get());
        model.addObject("roles", roleRepository.findAll());
        model.addObject("departments", departmentRepository.findAll());
        model.addObject("states", stateRepository.findAll());

        model.addObject("oldPrincipalRole", userService.getById(id).get().getRoles().iterator().next().getText());
        model.addObject("oldAdditionalRole", userService.getById(id).get().getRoles().iterator().next().getText());
        model.addObject("oldDepartment", userService.getById(id).get().getDepartment().getText());
        model.addObject("oldState", userService.getById(id).get().getState().getText());


        model.setViewName("userUpdate");
        return model;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value="/userUpdate{id}", method = RequestMethod.POST)
    public ModelAndView handleUserUpdatePage(ModelAndView model,
                                             @PathVariable Integer id,
                                             @Valid @ModelAttribute("form") UserUpdateForm form,
                                             BindingResult bindingResult){
        userService.update(form, id);
        model.setViewName("redirect:/usersList");
        return model;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value= "/userDelete{id}")
    public ModelAndView getUserDeletePage(ModelAndView model, @PathVariable Integer id){
        System.out.println(id);
        userService.delete(id);
        model.setViewName("redirect:/usersList");
        return model;
    }
}
