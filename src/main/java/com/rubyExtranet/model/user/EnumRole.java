package com.rubyExtranet.model.user;

public enum EnumRole {
	USER("USER"),
	ADMIN("ADMIN");
	 
	//private String role;
    
	private String EnumRole;
	
	private EnumRole(String EnumRole){
	    //this.role = role;
		this.EnumRole = EnumRole;
	}
	 
	public String getEnumRole(){
	    return EnumRole;
	}
}
