package com.rubyExtranet.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.rubyExtranet.mail.NewsletterMailSender;


//@Configuration
//@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
//@EnableScheduling
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
    private UserDetailsService userDetailsService;
	
	@Bean(name = "sessionRegistry")
	public SessionRegistry sessionRegistry() {
	  return new SessionRegistryImpl();
	}
	
//	@Autowired
//	private SessionRegistry sessionRegistry;
//	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/loginDesign").permitAll()
			// @see LoginController .antMatchers("/connect").authenticated() // WORKING FOR all Users //hasAuthority("ADMIN")// WORKING !!!! //.hasAnyRole("ADMIN")
			.antMatchers("/userCreate").permitAll()
		.and()
			.formLogin()
			.loginPage("/loginDesign")
			.usernameParameter("email") 
			.passwordParameter("password")
			.defaultSuccessUrl("/connect")
		.and()
			.logout().permitAll()
		//.and()
			//.rememberMe().userDetailsService(userDetailsService)
			//.loginProcessingUrl("/home")
		.and()
			.csrf()
			.disable()
			
			.headers()
			.frameOptions().disable()
		.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
			.maximumSessions(1).maxSessionsPreventsLogin(true)
			.expiredUrl("/loginDesign?expired")
			.sessionRegistry(sessionRegistry());
        
          //.and().exceptionHandling().accessDeniedPage("/home"); a chaque exception go to home
    }
	
    @Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
    

}
