package com.ruby.service;

import com.ruby.domain.Department;
import com.ruby.domain.Role;
import com.ruby.domain.State;
import com.ruby.domain.User;
import com.ruby.form.UserCreationForm;
import com.ruby.form.UserUpdateForm;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by ShdwBt on 11/09/2017.
 */
public interface UserService {
    Optional<User> getById(Integer id);

    Optional<User> getByEmail(String email);

    Collection<User> getAll();

    User create(UserCreationForm form);

    User update(UserUpdateForm form, Integer id);

    void delete(Integer id);

    Collection<Department> getDepartments();

    Collection<Role> getRoles();

    Collection<State> getStates();
}
