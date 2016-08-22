package com.ruby.rubyExtranet.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Department")
public class Department {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "pk_department_id", updatable = false)
    private Integer departmentId;
	
    @Column(name="department_text", unique=true, nullable=true)
    private String departmentText;

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer id) {
		this.departmentId = id;
	}

	public String getDepartmentText() {
		return departmentText;
	}

	public void setDepartmentText(String departmentText) {
		this.departmentText = departmentText;
	}
    
}
