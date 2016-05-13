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
import javax.persistence.Table;



@Entity
@Table (name = "User")
public class User {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "id_user", updatable = false)
    private long id;
	
    @Column(name="SSO_ID", unique=true, nullable=true)
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
    
    //variante Role
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "User_Role", 
             joinColumns = { @JoinColumn(name = "fk_user_id") }, 
             inverseJoinColumns = { @JoinColumn(name = "fk_role_id") })
    private Collection<Role> userRoles = new ArrayList<Role>();
    

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public Collection<Role> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Collection<Role> userRoles) {
		this.userRoles = userRoles;
	}

}
