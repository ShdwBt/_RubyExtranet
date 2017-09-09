package com.ruby.repository;

import com.ruby.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by ShdwBt on 09/09/2017.
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findOneById(Integer id);
    Role findOneByText(String text);
}
