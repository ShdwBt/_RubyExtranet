package com.rubyExtranet.model.user;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table (name = "User")
public class User {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "pk_user_id", updatable = false)
    private Integer userId;
     
    @Column(name="password", nullable=false)
    private String password;
         
    @Column(name="first_name", nullable=false)
    private String firstName;
 
    @Column(name="last_name", nullable=false)
    private String lastName;
 
    @Column(name="email", nullable=false)
    private String email;
  
    //variante Role
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "User_Role", 
             joinColumns = { @JoinColumn(name = "fk_user_id") }, 
             inverseJoinColumns = { @JoinColumn(name = "fk_role_id") })
    private Collection<Role> userRoles = new ArrayList<Role>();
    
    @ManyToOne
    @JoinColumn (name = "fk_department_id")
    private Department userDepartment;
    
    @ManyToOne
    @JoinColumn (name = "fk_state_id")
    private State userState;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<Role> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Collection<Role> userRoles) {
		this.userRoles = userRoles;
	}

	public Department getUserdepartment() {
		return userDepartment;
	}

	public void setUserDepartment(Department userDepartment) {
		this.userDepartment = userDepartment;
	}

	public State getUserState() {
		return userState;
	}

	public void setUserState(State userState) {
		this.userState = userState;
	}

}
