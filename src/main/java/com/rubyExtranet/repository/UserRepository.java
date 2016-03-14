package com.rubyExtranet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rubyExtranet.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findOneByEmail(String email);
}
