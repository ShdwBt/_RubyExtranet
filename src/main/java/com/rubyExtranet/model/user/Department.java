package com.rubyExtranet.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Departnement")
public class Department {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "id_department", updatable = false)
    private Integer id;
	
    @Column(name="department", unique=true, nullable=true)
    private String department;
    
}
