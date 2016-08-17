package com.rubyExtranet.repository;

import java.util.Optional;

import com.rubyExtranet.model.user.State;

public interface StateRepository {
	Optional<State> findOneById(Integer id);
	
	State findOneByStateText(String stateText);
}
