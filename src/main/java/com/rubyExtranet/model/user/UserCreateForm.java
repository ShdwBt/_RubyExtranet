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

    
    //@NotNull
    private Collection<Role> role;
    
    @NotNull
    private EnumState state = EnumState.ACTIVE;
    
    private Department department;

    
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

	public Collection<Role> getRole(){
		return role;
	}
	
	public void setRole(Collection<Role> role){
		this.role = role;
	}
	
	public EnumState getState() {
		return state;
	}

	public void setState(EnumState state) {
		this.state = state;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
		department.getDepartmentText();
	}
   
}
