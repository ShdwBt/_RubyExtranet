package com.rubyExtranet.model.subscriber;

import org.hibernate.validator.constraints.NotEmpty;

import com.rubyExtranet.model.subscriber.Subscriber.Frequency;

public class SubscriberCreateForm {
	@NotEmpty
    private String email = "";
	
	@NotEmpty
    private String gender = "";
	
	@NotEmpty
    private Frequency newsletterFrequency;

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

	public Frequency getNewsletterFrequency() {
		return newsletterFrequency;
	}

	public void setNewsletterFrequency(Frequency newsletterFrequency) {
		this.newsletterFrequency = newsletterFrequency;
	}
}
