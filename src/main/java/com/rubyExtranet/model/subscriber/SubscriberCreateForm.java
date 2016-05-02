package com.rubyExtranet.model.subscriber;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


public class SubscriberCreateForm {
	@NotEmpty
    private String email = "";
	
    private NewsletterFrequency newsletterFrequency;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public NewsletterFrequency getNewsletterFrequency() {
		System.out.println("get News");
		return newsletterFrequency;
	}

	public void setNewsletterFrequency(NewsletterFrequency newsletterFrequency) {
		System.out.println("set News");
		this.newsletterFrequency = newsletterFrequency;
	}
}
