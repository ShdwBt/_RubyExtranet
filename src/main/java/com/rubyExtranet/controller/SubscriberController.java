package com.rubyExtranet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rubyExtranet.model.subscriber.Subscriber;
import com.rubyExtranet.model.subscriber.Subscriber.Frequency;

@Controller
public class SubscriberController {
	@ModelAttribute("frequencies")
	public Frequency[] frequencies() {
		return Frequency.values();
	}

	@RequestMapping(value="/newslater", method=RequestMethod.GET)
	public ModelAndView loadFormPage(ModelAndView model) {
		model.addObject("subscriber", new Subscriber());
		model.setViewName("/subscribe");
		return model;
	}

	@RequestMapping(value="form", method=RequestMethod.POST)
	public ModelAndView submitForm(@ModelAttribute Subscriber subscriber, ModelAndView model) {
		model.addObject("message", "Successfully saved person: " + subscriber.toString());
		return model;
	}
}
