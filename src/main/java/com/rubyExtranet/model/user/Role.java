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
    private int role_id; 
 
    @Column(name="role_text", unique=true, nullable=false)
    private String role_text = EnumRole.USER.getEnumRole();

	public int getId() {
		return role_id;
	}

	public void setId(int role_id) {
		this.role_id = role_id;
	}

	public String getRole() {
		
		String roleText = role_text.toString().replace("[", "").replace("]", "");
		return roleText;
	}

	public void setRole(String role_text) {
		this.role_text = role_text;
	}

	@Override
	public String toString() {
		//return "Role [role_id=" + role_id + ", role_text=" + role_text + "]";
		// pour l'affichage in usersList
		String roleText = role_text.toString().replace("[", "").replace("]", "");
		return roleText;
	}
}
