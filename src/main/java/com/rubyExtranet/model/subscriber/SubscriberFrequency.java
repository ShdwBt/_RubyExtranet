package com.rubyExtranet.model.subscriber;

public enum SubscriberFrequency {
	HOURLY, 
	DAILY, 
	WEEKLY, 
	MONTHLY, 
	ANNUALLY;
	
	private String Frequency;

	public String getFrequency() {
		return Frequency;
	}

	public void setFrequency(String frequency) {
		Frequency = frequency;
	}
}
