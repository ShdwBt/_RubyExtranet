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


//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
    private UserDetailsService userDetailsService;


	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home", "/src/main/webapp/**").permitAll()
                .and()
            .formLogin()
                .loginPage("/loginDesign")
                .failureUrl("/loginDesign?error")
                .usernameParameter("email")
                .permitAll()
                .and()
            .logout()
            	.logoutUrl("/logout")
                .permitAll();
    }

	// Why Autowired ????????
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//            .inMemoryAuthentication()
//                .withUser("a@a").password("a").roles("USER");
//        		
//    }
	

    @Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
    	//UserDetailsService userDetailsService = new UserDetailsService();
		auth.userDetailsService(userDetailsService);
	}	
}
