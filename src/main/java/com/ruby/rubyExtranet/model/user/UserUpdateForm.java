package com.ruby.rubyExtranet.model.user;

import java.util.Collection;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class UserUpdateForm {
	
	@NotNull
	private Integer id;
	
	@NotEmpty
    private String email = "";

    private String firstName;
    
    private String lastName;
    
    private String principalRole;
    
    private String additionalRole;
    
    private String department;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPrincipalRole() {
		return principalRole;
	}

	public void setPrincipalRole(String principalRole) {
		this.principalRole = principalRole;
	}

	public String getAdditionalRole() {
		return additionalRole;
	}

	public void setAdditionalRole(String additionalRole) {
		this.additionalRole = additionalRole;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
