package com.rubyExtranet.service.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rubyExtranet.model.user.Department;
import com.rubyExtranet.model.user.Role;
import com.rubyExtranet.model.user.State;
import com.rubyExtranet.model.user.User;
import com.rubyExtranet.model.user.UserCreateForm;
import com.rubyExtranet.model.user.UserUpdateForm;
import com.rubyExtranet.repository.DepartmentRepository;
import com.rubyExtranet.repository.RoleRepository;
import com.rubyExtranet.repository.StateRepository;
import com.rubyExtranet.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	private DepartmentRepository departmentRepository;

	private RoleRepository roleRepository;

	private StateRepository stateRepository;
	
	@Autowired
    public UserServiceImpl(UserRepository userRepository, DepartmentRepository departmentRepository, RoleRepository roleRepository,
    		StateRepository stateRepository) {
        this.userRepository = userRepository;
        this.departmentRepository = departmentRepository;
        this.roleRepository = roleRepository;
        this.stateRepository = stateRepository;
    }
	

	
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
        
        Collection<Role> roles = new ArrayList<>();
        
        if (!form.getPrincipalRole().equals(null)){
        	Role principalRole = roleRepository.findOneByRoleText(form.getPrincipalRole());
        	roles.add(principalRole);
        }
        
        if (!form.getAdditionalRole().equals(null)){
        	Role additionallRole = roleRepository.findOneByRoleText(form.getAdditionalRole());
        	roles.add(additionallRole);
        }
        
        user.setUserRoles(roles);
        //si rolerepo == null sinon add role in array list 
        
        State st = stateRepository.findOneByStateText(form.getState());
        user.setUserState(st);
        
        Department dpt = departmentRepository.findOneByDepartmentText(form.getDepartment());
        user.setUserDepartment(dpt);
        
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
		return departmentRepository.findAll(new Sort("departementId"));
	}

	@Override
	public Collection<Role> getAllRole() {
		return roleRepository.findAll();

	}
	
}
