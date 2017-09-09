package com.ruby.repository;

import com.ruby.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by ShdwBt on 09/09/2017.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findOneByEmail(String email);
}
