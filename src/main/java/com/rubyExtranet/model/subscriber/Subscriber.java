package com.rubyExtranet.model.subscriber;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "subscriber")
public class Subscriber {
	
	private String email;
	private Frequency newsletterFrequency;
	private Gender gender;
	private Boolean receiveNewsletter;

	public enum Frequency {
		HOURLY, DAILY, WEEKLY, MONTHLY, ANNUALLY
	}

	public enum Gender {
		MALE, FEMALE
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Frequency getNewsletterFrequency() {
		return newsletterFrequency;
	}

	public void setNewsletterFrequency(Frequency newsletterFrequency) {
		this.newsletterFrequency = newsletterFrequency;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Boolean getReceiveNewsletter() {
		return receiveNewsletter;
	}

	public void setReceiveNewsletter(Boolean receiveNewsletter) {
		this.receiveNewsletter = receiveNewsletter;
	}

	@Override
	public String toString() {
		return "Subscriber [email=" + email + ", newsletterFrequency=" + newsletterFrequency + ", gender=" + gender
				+ ", receiveNewsletter=" + receiveNewsletter + "]";
	}

}
