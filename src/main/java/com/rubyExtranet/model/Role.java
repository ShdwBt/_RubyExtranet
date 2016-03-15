package com.rubyExtranet.model;

public enum Role {
	USER("USER"),
    DBA("DBA"),
    ADMIN("ADMIN");
	
	/* USER, DBA, ADMIN  without nothing after*/
	 
	private String role;
    
	private Role(String role){
	    this.role = role;
	}
	 
	public String getRole(){
	    return role;
	}
}
