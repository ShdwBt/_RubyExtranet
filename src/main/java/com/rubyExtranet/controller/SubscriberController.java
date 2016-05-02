package com.rubyExtranet.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rubyExtranet.model.subscriber.NewsletterFrequency;
import com.rubyExtranet.model.subscriber.Subscriber;
import com.rubyExtranet.model.subscriber.SubscriberCreateForm;
import com.rubyExtranet.service.subscriber.SubscriberService;

@Controller
public class SubscriberController {
	
	private SubscriberService subscriberService;

	@Autowired
	public SubscriberController(SubscriberService subscriberService){//, SubcriberCreateFormValidator subcriberCreateFormValidator) {
	        this.subscriberService = subscriberService;
	        //this.subcriberCreateFormValidator = subcriberCreateFormValidator;
	    }
	 
//	@InitBinder("form")
//  public void initBinder(WebDataBinder binder) {
//      binder.addValidators(subcriberCreateFormValidator);
//  }
	 
//	@ModelAttribute("frequencies")
//	public NewsletterFrequency[] frequencies() {
//		return NewsletterFrequency.values();
//	}

	@RequestMapping(value="/subscribe", method=RequestMethod.GET)
	public ModelAndView loadSubscribeFormPage(ModelAndView model) {
		SubscriberCreateForm subscriberForm = new SubscriberCreateForm();
		model.addObject("form", subscriberForm);
		model.addObject("frequencies", NewsletterFrequency.values());
		model.setViewName("subscribe");
		return model;
	}

//	@RequestMapping(value="/subscribe", method=RequestMethod.POST)
//	public ModelAndView submitForm(@ModelAttribute Subscriber subscriber, ModelAndView model) {
//		model.addObject("message", "Successfully saved person");//: " + subscriber.toString());
//		return model;
//	}
	
	@RequestMapping(value="/subscribe", method=RequestMethod.POST)
	public ModelAndView submitSubscribeForm(ModelAndView model, @Valid @ModelAttribute("form") SubscriberCreateForm form, BindingResult bindingResult) {
//		if (bindingResult.hasErrors()) {
//			model.setViewName("subscribe");
//			System.out.println("Erreur");
//            return model;
//        }
        try {
        	subscriberService.create(form);
        } catch (DataIntegrityViolationException e) {
            bindingResult.reject("email.exists", "Email already exists");
            model.setViewName("subscribe");
            return model;
        }
        model.setViewName("redirect:/subscribe");
        return model;
	}
	
}
