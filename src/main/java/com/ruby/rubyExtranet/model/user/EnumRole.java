package com.ruby.rubyExtranet.model.user;

public enum EnumRole {
	
	USER("USER"),
	ADMIN("ADMIN");
	 
	private String EnumRole;
	
	private EnumRole(String EnumRole){
		this.EnumRole = EnumRole;
	}
	 
	public String getEnumRole(){
	    return EnumRole;
	}
	
}
