package com.rubyExtranet.service.user;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rubyExtranet.model.user.Department;
import com.rubyExtranet.model.user.Role;
import com.rubyExtranet.model.user.User;
import com.rubyExtranet.model.user.UserCreateForm;
import com.rubyExtranet.model.user.UserUpdateForm;
import com.rubyExtranet.repository.DepartmentRepository;
import com.rubyExtranet.repository.RoleRepository;
import com.rubyExtranet.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	
	@Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Optional<User> getUserById(Integer id) {
		return Optional.ofNullable(userRepository.findOne(id));
	}

	@Override
	public Optional<User> getUserByEmail(String email) {
		return userRepository.findOneByEmail(email);
	}

	@Override
	public Collection<User> getAllUsers() {
		return userRepository.findAll(new Sort("email"));
	}

	

	@Override
	public User create(UserCreateForm form) {
		User user = new User();
		user.setFirstName(form.getFirstName());
		user.setLastName(form.getLastName());
        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());
        user.setUserRoles(form.getRole());
        user.setUserDepartment(form.getDepartment());
        
        return userRepository.save(user);
	}
	

	@Override
	public User updateUser(UserUpdateForm form, Integer id) {
		System.out.println("Updating a User");
		User userUpdated = userRepository.findOne((Integer)id);
		userUpdated.setFirstName(form.getFirstName());
		userUpdated.setLastName(form.getLastName());
		userUpdated.setEmail(form.getEmail());
		
		return userRepository.save(userUpdated);
	}

	@Override
	public void deleteUser(Integer id) {
		userRepository.delete((Integer)id);
		
	}

	@Override
	public Collection<Department> getAllDepartments() {
		return departmentRepository.findAll(new Sort("id"));
	}

	@Override
	public Collection<Role> getAllRole() {
		return roleRepository.findAll();

	}

}
