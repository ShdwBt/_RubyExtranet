package com.rubyExtranet.config.springIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.rubyExtranet.service.user.UserService;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	
//	private final UserService userService;
//	
//    @Autowired
//    public WebSecurityConfig(UserService userService) {
//        this.userService = userService;
//    }
	
	
	@Autowired
    private UserDetailsService userDetailsService;


	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home", "/src/main/webapp/**")
                	.permitAll()
                .antMatchers("/","/resources/**")
                	.permitAll()
            .and()
            .formLogin()
                .loginPage("/loginDesign")
                .failureUrl("/loginDesign?error")
                .usernameParameter("email")
                .passwordParameter("password")
//                .loginProcessingUrl("/connect")
//                .permitAll()
                .and()
                .csrf()
                .disable()
            .logout()
            	.logoutUrl("/logout")
                .permitAll();
    }
	
    @Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}	
}
