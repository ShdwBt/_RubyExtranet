package com.rubyExtranet.model.user;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
    
    @Column(name="ROLE", nullable=false) 
    @Enumerated(EnumType.STRING)
    private Role role;
    
    //variante Role
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "User_Role", 
             joinColumns = { @JoinColumn(name = "fk_id_user") }, 
             inverseJoinColumns = { @JoinColumn(name = "id_role_user") })
    private Set<RoleUser> userProfiles = new HashSet<RoleUser>();
    
//    private Department department;
    
//    //@NotNull
//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "Department" )
//    @JoinColumn(name = "id_department")
//    private Integer fk_id_department;
    
    
//	  Pour séparer les profils users de cette table
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "APP_USER_USER_PROFILE", 
//             joinColumns = { @JoinColumn(name = "USER_ID") }, 
//             inverseJoinColumns = { @JoinColumn(name = "USER_PROFILE_ID") })
//    private Set<UserProfile> userProfiles = new HashSet<UserProfile>();

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


	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

//	public Integer getFk_id_department() {
//		return fk_id_department;
//	}
//
//	public void setFk_id_department(Integer fk_id_department) {
//		this.fk_id_department = fk_id_department;
//	}

//	public String getState() {
//		return state;
//	}
//
//	public void setState(String state) {
//		this.state = state;
//	}
}
