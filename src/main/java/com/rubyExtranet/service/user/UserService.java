package com.rubyExtranet.service.user;

import java.util.Collection;
import java.util.Optional;

import com.rubyExtranet.model.user.Department;
import com.rubyExtranet.model.user.Role;
import com.rubyExtranet.model.user.User;
import com.rubyExtranet.model.user.UserCreateForm;
import com.rubyExtranet.model.user.UserUpdateForm;

public interface UserService {
	
	Optional<User> getUserById(Integer id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);

    User updateUser(UserUpdateForm form, Integer id);
    
	void deleteUser(Integer id);
	
	Collection<Department> getAllDepartments();
	
	Collection<Role> getAllRole();
    
}
