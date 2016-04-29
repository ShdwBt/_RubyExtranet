package com.rubyExtranet.model.user;

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

//    @NotNull
//    private Role[] rolesList;// = Role.USER;//getRole();
    //private Role role;
    
    private String stringRole = "";
    
    //@NotNull
    private Role role;
    
    @NotNull
    private State state = State.ACTIVE;

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

//	public Role[] getRolesList() {
//		return rolesList;
//	}
	
	public String getStringRole() {
		return stringRole;
	}

	public void setStringRole(String stringRole) {
		this.stringRole = stringRole;
	}

	public Role getRole(){
		return role;
	}
	
	public void setRole(Role role){
		this.role = role;
	}
	
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
    

}
