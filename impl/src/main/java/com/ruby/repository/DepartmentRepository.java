package com.ruby.repository;

import com.ruby.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by ShdwBt on 09/09/2017.
 */
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findOneById(Integer id);
    Department findOneByText(String text);
}
