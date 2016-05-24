package com.rubyExtranet.model.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.rubyExtranet.service.user.UserService;

public class UserUpdateFormValidator implements Validator{

	private final UserService userService;

    @Autowired
    public UserUpdateFormValidator(UserService userService) {
        this.userService = userService;
    }
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(UserCreateForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserUpdateForm form = (UserUpdateForm) target;
	    validateEmail(errors, form);
		
	}
	

    private void validateEmail(Errors errors, UserUpdateForm form) {
        if (userService.getUserByEmail(form.getEmail()).isPresent()) {
            errors.reject("email.exists", "User with this email already exists");
        }
    }

}
