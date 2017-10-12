package com.ruby.config;

import com.ruby.domain.Role;
import com.ruby.domain.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ShdwBt on 24/09/2017.
 */
@Getter
public class CurrentUser extends org.springframework.security.core.userdetails.User {
    private User user;

    public CurrentUser(User user) {
        super(user.getEmail(), user.getPassword(), getGrantedAuthorities(user));
    }

    private static List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for(Role role : user.getRoles()){
            authorities.add(new SimpleGrantedAuthority(role.getText()));
        }
        System.out.print("authorities :"+authorities);
        return authorities;
    }
}
