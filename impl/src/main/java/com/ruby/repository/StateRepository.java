package com.ruby.repository;

import com.ruby.domain.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by ShdwBt on 09/09/2017.
 */
public interface StateRepository extends JpaRepository<State, Long> {
    Optional<State> findOneById(Integer id);
    State findOneByText(String text);
}
