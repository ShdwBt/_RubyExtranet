package com.rubyExtranet.model.user;

public enum Role {
	//USER("USER"),
	// DBA("DBA"),
	USER("USER"),
	DIRECTORATE_GENERAL("DIRECTORATE GENERAL"),
	ADMIN("ADMIN"),
    HUMAN_RESOURCES("HUMAN_RESOURCES"),
    COMMERCIAL("COMMERCIAL"),
    DELIVERY("DELIVERY"),
    MARKETING("MARKETING"),
    MANUFACTURING("MANUFACTURING"),
    IT("IT");
	
	
	/* USER, DBA, ADMIN  without nothing after*/
	 
	private String role;
    
	private Role(String role){
	    this.role = role;
	}
	 
	public String getRole(){
	    return role;
	}
}
