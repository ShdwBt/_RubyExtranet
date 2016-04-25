package com.rubyExtranet.model.user.currentUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rubyExtranet.model.user.CurrentUser;
import com.rubyExtranet.model.user.User;
import com.rubyExtranet.service.user.UserService;

@Service
public class CurrentUserDetailsService implements UserDetailsService {

    private final UserService userService;

	// public CurrentUserDetailsService(UserService userService) {this.userService = userService;}
    @Autowired
    public CurrentUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CurrentUser loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.getUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email=%s was not found", email)));
        return new CurrentUser(user);
    }

}