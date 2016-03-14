package com.rubyExtranet.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import com.rubyExtranet.model.User;
import com.rubyExtranet.model.UserCreateForm;
import com.rubyExtranet.repository.UserRepository;

public class UserServiceImpl implements UserService {

	 private final UserRepository userRepository;
	
	@Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	@Override
	public Optional<User> getUserById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<User> getAllUsers() {
		return userRepository.findAll(new Sort("email"));
	}

	@Override
	public User create(UserCreateForm form) {
		User user = new User();
        user.setEmail(form.getEmail());
        //user.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
        user.setPassword(form.getPassword());
        user.setRole(form.getRole());
        return userRepository.save(user);
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findBySso(String sso) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
