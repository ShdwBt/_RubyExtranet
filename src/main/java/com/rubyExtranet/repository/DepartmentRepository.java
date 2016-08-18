package com.rubyExtranet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rubyExtranet.model.user.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
	Optional<Department> findOneByDepartmentId(Integer departmentId);
	
	Department findOneByDepartmentText(String departmentText);
}
