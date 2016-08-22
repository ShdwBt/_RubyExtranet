package com.ruby.rubyExtranet.service.user;

import java.util.Collection;
import java.util.Optional;

import com.ruby.rubyExtranet.model.user.Department;
import com.ruby.rubyExtranet.model.user.Role;
import com.ruby.rubyExtranet.model.user.User;
import com.ruby.rubyExtranet.model.user.UserCreateForm;
import com.ruby.rubyExtranet.model.user.UserUpdateForm;

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
