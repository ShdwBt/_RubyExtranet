package com.ruby.rubyExtranet.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "State")
public class State {
	
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="pk_state_id", updatable = false, unique = true, nullable = false)
    private Integer stateId; 
 
    @Column(name="state_text", unique=true, nullable=false)
    private String stateText;
    
	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public String getStateText() {
		return stateText;
	}

	public void setStateText(String stateText) {
		this.stateText = stateText;
	}

}
