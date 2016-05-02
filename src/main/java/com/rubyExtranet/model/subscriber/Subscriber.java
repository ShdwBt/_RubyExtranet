package com.rubyExtranet.model.subscriber;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.rubyExtranet.model.user.Role;

@Entity
@Table (name = "subscriber")
public class Subscriber {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "id_subscriber", updatable = false)
    private int id;
	
	@Column(name="EMAIL", nullable=false)
	private String email;
	
	@Column(name="FREQUENCY", nullable=false)
	@Enumerated(EnumType.STRING)
	private NewsletterFrequency newsletterFrequency;
	
	//private Role role;
	
//	public enum Frequency {
//		HOURLY, DAILY, WEEKLY, MONTHLY, ANNUALLY
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public NewsletterFrequency getNewsletterFrequency() {
		return newsletterFrequency;
	}

	public void setNewsletterFrequency(NewsletterFrequency newsletterFrequency) {
		this.newsletterFrequency = newsletterFrequency;
	}


}
