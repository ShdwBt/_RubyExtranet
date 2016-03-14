package com.rubyExtranet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "User")
public class User {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
 
    @Column(name="SSO_ID", unique=true, nullable=false)
    private String ssoId;
     
    @Column(name="PASSWORD", nullable=false)
    private String password;
         
    @Column(name="FIRST_NAME", nullable=false)
    private String firstName;
 
    @Column(name="LAST_NAME", nullable=false)
    private String lastName;
 
    @Column(name="EMAIL", nullable=false)
    private String email;
    
    @Column(name="STATE", nullable=false)
    private String state=State.ACTIVE.getState();
    
    @Column(name="ROLE", nullable=false) 
    @Enumerated(EnumType.STRING)
    private Role role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSsoId() {
		return ssoId;
	}

	public void setSsoId(String ssoId) {
		this.ssoId = ssoId;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", ssoId=" + ssoId + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + "]";
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
