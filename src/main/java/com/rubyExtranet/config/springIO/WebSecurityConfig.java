package com.rubyExtranet.config.springIO;
//package com.rubyExtranet.config;
//
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
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//	
//	@Autowired
//	DataSource dataSource;
//	
//	@Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//                .antMatchers("/", "/home", "/src/main/webapp/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//            .formLogin()
//                .loginPage("/loginDesign")
//                .permitAll()
//                .and()
//            .logout()
//                .permitAll();
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//            .inMemoryAuthentication()
//                .withUser("ash@sh").password("ash").roles("ADMIN");
//    }
//    @Autowired
//	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//		
//		auth.jdbcAuthentication().dataSource(dataSource)
//			.usersByUsernameQuery("select email, password, state from user where email=?")
//			.authoritiesByUsernameQuery("select email, role from user where email=?");
//	}	
//}