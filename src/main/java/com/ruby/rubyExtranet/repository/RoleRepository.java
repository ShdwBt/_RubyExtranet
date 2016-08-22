package com.ruby.rubyExtranet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruby.rubyExtranet.model.user.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	Optional<Role> findOneByRoleId(Integer roleId);
	
	Role findOneByRoleText(String roleText);
}
