package com.ruby.rubyExtranet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruby.rubyExtranet.model.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findOneByEmail(String email);
}
