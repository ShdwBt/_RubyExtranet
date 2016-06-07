package com.rubyExtranet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rubyExtranet.model.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findOneByEmail(String email);
}
