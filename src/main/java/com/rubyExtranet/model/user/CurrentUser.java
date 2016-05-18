package com.rubyExtranet.model.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private User user;

//    public CurrentUser(User user) {
//        super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getUserRoles().toString()));
//        this.user = user;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public long getId() {
//        return user.getId();
//    }
//
//    public Collection<Role> getRole() {
//        return user.getUserRoles();
//    }
	public CurrentUser(User user) {
		super(user.getEmail(), user.getPassword(), getGrantedAuthorities(user));
	}
	
	public User getUser() {
		return user;
	}
	
	//http://websystique.com/spring-security/spring-security-4-hibernate-role-based-login-example/ possibilité de réutilisation pou
	private static List<GrantedAuthority> getGrantedAuthorities(User user){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(Role userRole : user.getUserRoles()){
			authorities.add(new SimpleGrantedAuthority(userRole.getRole()));
			//authorities.add(new SimpleGrantedAuthority(userRole.getRole()));
			
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
