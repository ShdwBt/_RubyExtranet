package com.rubyExtranet.service;

import java.util.Collection;
import java.util.Optional;

import com.rubyExtranet.model.user.User;
import com.rubyExtranet.model.user.UserCreateForm;

public interface UserService {
	//kielczewski class down here
	Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);
    
    //Websystique class down here
    User findById(int id);
    
    User findBySso(String sso);
}
