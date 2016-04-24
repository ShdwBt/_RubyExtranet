package com.rubyExtranet.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rubyExtranet.model.subscriber.Subscriber;
import com.rubyExtranet.model.subscriber.Subscriber.Frequency;
import com.rubyExtranet.model.user.UserCreateForm;
import com.rubyExtranet.service.SubscriberService;
import com.rubyExtranet.service.UserService;
import com.rubyExtranet.model.subscriber.SubscriberCreateForm;

@Controller
public class SubscriberController {
	
	private SubscriberService subscriberService;

	@Autowired
	public SubscriberController(SubscriberService subscriberService){//, UserCreateFormValidator userCreateFormValidator) {
	        this.subscriberService = subscriberService;
	    }
	 
	 
	@ModelAttribute("frequencies")
	public Frequency[] frequencies() {
		return Frequency.values();
	}

	@RequestMapping(value="/subscribe", method=RequestMethod.GET)
	public ModelAndView loadFormPage(ModelAndView model) {
		SubscriberCreateForm subscriberForm = new SubscriberCreateForm();
		model.addObject("form", subscriberForm);
		model.addObject("subscriber", new Subscriber());
		model.addObject("frequencies", Frequency.values());
		model.setViewName("/subscribe");
		return model;
	}

//	@RequestMapping(value="/subscribe", method=RequestMethod.POST)
//	public ModelAndView submitForm(@ModelAttribute Subscriber subscriber, ModelAndView model) {
//		model.addObject("message", "Successfully saved person");//: " + subscriber.toString());
//		return model;
//	}
	
	@RequestMapping(value="/subscribe", method=RequestMethod.POST)
	public String submitForm(@Valid @ModelAttribute("form") SubscriberCreateForm form, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
            return "subscribe";
        }
        try {
        	subscriberService.create(form);
        } catch (DataIntegrityViolationException e) {
            bindingResult.reject("email.exists", "Email already exists");
            return "userCreateWithForm";
        }
        return "redirect:/subscribe";
	}
	
}
