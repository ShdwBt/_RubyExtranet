package com.rubyExtranet.model.user;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "State")
public class State {
	
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="pk_state_id", updatable = false, unique = true, nullable = false)
    private Integer userStateId; 
 
    @Column(name="state_text", unique=true, nullable=false)
    @Enumerated(EnumType.STRING)
    private EnumState UserStateText;
    
    @OneToMany(mappedBy = "state")
    private Collection<User> users;

	public Integer getUserStateId() {
		return userStateId;
	}

	public void setUserStateId(Integer userStateId) {
		this.userStateId = userStateId;
	}

	public EnumState getUserStateText() {
		return UserStateText;
	}

	public void setUserStateText(EnumState userStateText) {
		UserStateText = userStateText;
	}

}
