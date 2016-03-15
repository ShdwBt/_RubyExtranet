package com.rubyExtranet.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rubyExtranet.model.User;
import com.rubyExtranet.model.UserCreateForm;
import com.rubyExtranet.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	 private final UserRepository userRepository;
	
	@Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	@Override
	public Optional<User> getUserById(long id) {
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
		// add of id for dupplicate id prob
		
		//user.setId(1); erase the record 
		
		user.setFirstName(form.getFirstName());
		user.setLastName(form.getLastName());
        user.setEmail(form.getEmail());
        //user.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
        user.setPassword(form.getPassword());
        user.setRole(form.getRole());
        // ssoId become an int, auto incremented user.setSsoId("1");
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
