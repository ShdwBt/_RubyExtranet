package com.rubyExtranet.model.user;

import java.util.Collection;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
public class UserCreateForm {

	
	@NotEmpty
    private String email = "";

    @NotEmpty
    private String password = "";

    @NotEmpty
    private String passwordRepeated = "";
    
    private String firstName;
    
    private String lastName;

    private String principalRole;

    private String additionalRole;
    
    @NotNull
    private String state; 

    private String department;

    
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordRepeated() {
		return passwordRepeated;
	}

	public void setPasswordRepeated(String passwordRepeated) {
		this.passwordRepeated = passwordRepeated;
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
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
   
}
