package com.ruby.rubyExtranet.model.user;

public enum EnumDepartment {

	DIRECTORATE_GENERAL("DIRECTORATE_GENERAL"),
	ADMINISTRATION("ADMINISTRATION"),
	HR("HR"),
	COMMERCIAL("COMMERCIAL"),
	DELIVERY("DELIVERY"),
	MARKETING("MARKETING"),
	MANUFACTURING("MANUFACTURING"),
	IT("IT");
	
	public String department;

	private EnumDepartment(String department) {
		this.department = department;
	}
	
	public String getEnumDepartment() {
		return department;
	}
	
}
