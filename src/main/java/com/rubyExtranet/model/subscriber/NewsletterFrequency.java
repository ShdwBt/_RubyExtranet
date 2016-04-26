package com.rubyExtranet.model.subscriber;

public enum NewsletterFrequency {
	HOURLY("HOURLY"),
	DAILY("DAILY"), 
	WEEKLY("WEEKLY"), 
	MONTHLY("MONTHLY"), 
	ANNUALLY("ANNUALLY");
	
	private String NewsletterFrequency;

	public String getNewsletterFrequency() {
		return NewsletterFrequency;
	}
	
	private NewsletterFrequency(String newsletterFrequency) {
		NewsletterFrequency = newsletterFrequency;
	}
	
}
