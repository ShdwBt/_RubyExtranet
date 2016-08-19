package com.rubyExtranet.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
    private UserDetailsService userDetailsService;
	
	@Autowired
	private SessionRegistry sessionRegistry;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		
		http
			.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/extranetLogin").permitAll()
		.and()
			.formLogin()
			.loginPage("/extranetLogin")
			.usernameParameter("email") 
			.passwordParameter("password")
			.defaultSuccessUrl("/connect")
		.and()
			.logout().permitAll()
//		.and()
//			.exceptionHandling().accessDeniedPage("/home") //a changer
		.and()
			.csrf()
			.disable()			
		.headers()
			.frameOptions().disable()
		.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
			.maximumSessions(1).maxSessionsPreventsLogin(true)
			.expiredUrl("/extranetLogin?expired")
			.sessionRegistry(sessionRegistry);
        
    }
	
    @Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
    
}
