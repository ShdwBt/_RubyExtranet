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

import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Table (name = "User")
public class User {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "pk_user_id", updatable = false)
    private long id;
     
    @Column(name="password", nullable=false)
    private String password;
         
    @Column(name="FIRST_NAME", nullable=false)
    private String firstName;
 
    @Column(name="LAST_NAME", nullable=false)
    private String lastName;
 
    @Column(name="EMAIL", nullable=false)
    private String email;
  
    //variante Role
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "User_Role", 
             joinColumns = { @JoinColumn(name = "fk_user_id") }, 
             inverseJoinColumns = { @JoinColumn(name = "fk_role_id") })
    private Collection<Role> userRoles = new ArrayList<Role>();
    
    //http://blog.paumard.org/cours/jpa/chap03-entite-relation.html
    @NotEmpty
    @ManyToOne
    @JoinColumn (name = "fk_department_id")
    private Department department;
    
    @Column(name="STATE", nullable=false)
    private String state=EnumState.ACTIVE.getState();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
