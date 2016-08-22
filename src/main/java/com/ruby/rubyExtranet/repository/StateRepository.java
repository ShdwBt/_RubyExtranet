package com.ruby.rubyExtranet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruby.rubyExtranet.model.user.State;

public interface StateRepository  extends JpaRepository<State, Long>{
	Optional<State> findOneByStateId(Integer stateId);
	
	State findOneByStateText(String stateText);
}
