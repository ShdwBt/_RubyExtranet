package com.rubyExtranet.model.subscriber;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


public class SubscriberCreateForm {
	@NotEmpty
    private String email = "";
	
	@NotEmpty
    private String gender = "";
	
	@NotNull
    private NewsletterFrequency newsletterFrequency;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public NewsletterFrequency getNewsletterFrequency() {
		return newsletterFrequency;
	}

	public void setNewsletterFrequency(NewsletterFrequency newsletterFrequency) {
		this.newsletterFrequency = newsletterFrequency;
	}
}
