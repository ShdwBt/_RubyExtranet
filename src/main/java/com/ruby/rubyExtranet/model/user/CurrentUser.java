package com.ruby.rubyExtranet.model.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@SuppressWarnings("serial")
public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private User user;

	public CurrentUser(User user) {
		super(user.getEmail(), user.getPassword(), getGrantedAuthorities(user));
	}
	
	public User getUser() {
		return user;
	}
	
	private static List<GrantedAuthority> getGrantedAuthorities(User user){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(Role userRole : user.getUserRoles()){
			authorities.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		System.out.print("authorities :"+authorities);
		return authorities;
	}

    @Override
    public String toString() {
        return "CurrentUser{" +
                "user=" + user +
                "} " + super.toString();
    }
    
}
