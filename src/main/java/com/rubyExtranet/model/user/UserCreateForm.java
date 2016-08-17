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

    private Collection<Role> role;
    
    @NotNull
    private String state; 

    private String department;

//    private Department dpt = departmentRepository.findOneByDepartmentText(departmentText);
    
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

//	public Department getDpt() {
//		return dpt;
//	}
//
//	public void setDpt(Department dpt) {
//		this.dpt = dpt;
//	}
   
}
