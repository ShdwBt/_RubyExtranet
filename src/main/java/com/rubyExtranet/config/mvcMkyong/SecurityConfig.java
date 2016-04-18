//package com.rubyExtranet.config.mvcMkyong;
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	DataSource dataSource;
//	
//	@Autowired
//	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//		
//	  auth.jdbcAuthentication().dataSource(dataSource)
//		.usersByUsernameQuery(
//			"select email,password, active from user where email=?")
//		.authoritiesByUsernameQuery(
//			"select email, role from role where email=?");
//	}	
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//	  http.authorizeRequests()
//		.antMatchers("/admin/**").access("hasRole('ADMIN')")
//		.and()
//		  .formLogin().loginPage("/loginDesign").failureUrl("/loginDesign?error")
//		  .usernameParameter("email").passwordParameter("password")
//		.and()
//		  .logout().logoutSuccessUrl("/login?logout")
//		.and()
//		  .exceptionHandling().accessDeniedPage("/403")
//		.and()
//		  .csrf();
//	}
//}