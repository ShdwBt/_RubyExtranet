package com.rubyExtranet.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
	
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="pk_role_id", updatable = false, unique = true, nullable = false)
    private Integer roleId; 
 
    @Column(name="role_text", unique=true, nullable=false)
    private String roleText;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer id) {
		this.roleId = id;
	}

	public String getRole(){
		return roleText;
	}

	public void setRole(String roleText) {
		this.roleText = roleText;
	}

	@Override
	public String toString() {
		String roleTexte = roleText.toString().replace("[", " ").replace("]", " ");
		return roleTexte;
	}
	
}
