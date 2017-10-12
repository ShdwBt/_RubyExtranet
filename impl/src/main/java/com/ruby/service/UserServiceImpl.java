package com.ruby.service;

import com.ruby.domain.Department;
import com.ruby.domain.Role;
import com.ruby.domain.State;
import com.ruby.domain.User;
import com.ruby.form.UserCreationForm;
import com.ruby.form.UserUpdateForm;
import com.ruby.repository.DepartmentRepository;
import com.ruby.repository.RoleRepository;
import com.ruby.repository.StateRepository;
import com.ruby.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

/**
 * Created by ShdwBt on 21/09/2017.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
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
    public Optional<User> getById(Integer id) {
        return Optional.ofNullable(userRepository.findOne(id));
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    @Override
    public Collection<User> getAll() {
        return userRepository.findAll(new Sort("email"));
    }

    @Override
    public User create(UserCreationForm form) {
        User user = new User();

        Department department = departmentRepository.findOneByText(form.getDepartment());
        State st = stateRepository.findOneByText(form.getState());

        Collection<Role> roles = new ArrayList<>();
        if (!form.getPrincipalRole().equals(null)){
            Role principalRole = roleRepository.findOneByText(form.getPrincipalRole());
            roles.add(principalRole);
        }
        if (!form.getAdditionalRole().equals(null)){
            Role additionallRole = roleRepository.findOneByText(form.getAdditionalRole());
            roles.add(additionallRole);
        }
        user.setFirstname(form.getFirstname());
        user.setLastname(form.getLastname());
        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());
        user.setRoles(roles);
        user.setState(st);
        user.setDepartment(department);

        return userRepository.save(user);
    }

    @Override
    public User update(UserUpdateForm form, Integer id){
        System.out.println("Updating a User");
        User userUpdated = userRepository.findOne(id);
        Department department = departmentRepository.findOneByText(form.getDepartment());
        State state = stateRepository.findOneByText(form.getState());

        userUpdated.setFirstname(form.getFirstname());
        userUpdated.setLastname(form.getLastname());
        userUpdated.setEmail(form.getEmail());
        userUpdated.setDepartment(department);
        userUpdated.setState(state);

        //roles update to add
        return userRepository.save(userUpdated);
    }

    @Override
    public void delete(Integer id) {
        userRepository.delete(id);
    }

    @Override
    public Collection<Department> getDepartments(){
        return departmentRepository.findAll(new Sort("id"));
    }

    @Override
    public Collection<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Collection<State> getStates(){ return stateRepository.findAll();}
}
