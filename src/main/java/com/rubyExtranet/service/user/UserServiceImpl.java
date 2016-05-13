package com.rubyExtranet.service.user;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rubyExtranet.model.user.EnumRole;
import com.rubyExtranet.model.user.User;
import com.rubyExtranet.model.user.UserCreateForm;
import com.rubyExtranet.model.user.UserUpdateForm;
import com.rubyExtranet.repository.UserRepository;

@Service
//@Transactional ?? CRUD
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
		user.setFirstName(form.getFirstName());
		user.setLastName(form.getLastName());
        user.setEmail(form.getEmail());
        //user.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
        user.setPassword(form.getPassword());
        
        
        user.setUserRoles(
        		
        		form.getRole());
        
        
        // ssoId become an int, auto incremented user.setSsoId("1");
        return userRepository.save(user);
	}

	@Override
	public User updateUser(UserUpdateForm form) {
		System.out.println("Updating a User");
		User userUpdated = new User();
		userUpdated = findById(form.getId());
		//userRepository.delete(u);
		userUpdated.setFirstName(form.getFirstName());
		userUpdated.setLastName(form.getLastName());
		userUpdated.setEmail(form.getEmail());
		userUpdated.setPassword(form.getPassword());
		return userRepository.save(userUpdated);
	}
	

	@Override
	public void updateUserv3(String firstname, String lastname, String email, long id, User user) {
		firstname = user.getFirstName();
		lastname = user.getLastName();
		email = user.getEmail();
		id = user.getId();
//		User userUpdated = new User();
//		userUpdated.setFirstName(user.getFirstName());
//		userUpdated.setLastName(user.getLastName());
//		userUpdated.setEmail(user.getEmail());
//		userRepository.save(userUpdated);
	}

	@Override
	public User updateUserv2(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteUser(long id) {
		Optional<User> u = getUserById(id);
		userRepository.delete(id);
	}

	@Override
	public void deleteUser(int id) {
		userRepository.delete((long)id);
		
	}

	
	
	@Override
	public User findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public User findBySso(String sso) {
		// TODO Auto-generated method stub
		return null;
	}

}
