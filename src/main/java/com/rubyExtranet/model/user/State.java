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
    private Integer stateId; 
 
    @Column(name="state_text", unique=true, nullable=false)
    @Enumerated(EnumType.STRING)
    private EnumState stateText;
    
//    @OneToMany(mappedBy = "state")
//    private Collection<User> users;

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public EnumState getStateText() {
		return stateText;
	}

	public void setStateText(EnumState stateText) {
		this.stateText = stateText;
	}

}
