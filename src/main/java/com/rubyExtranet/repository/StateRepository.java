package com.rubyExtranet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rubyExtranet.model.user.State;

public interface StateRepository extends JpaRepository<State, Long>{
//	Optional<State> findOneById(Integer pk_state_id);
}
