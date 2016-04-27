package com.rubyExtranet.service.user;

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
    
	void updateUser(User user);
	
	void deleteUser(int id);
    
    //Websystique class down here
    User findById(long id);
    
    User findBySso(String sso);
}
