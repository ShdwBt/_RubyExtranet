//package com.rubyExtranet.config.springIO;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.SecurityProperties;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//
//
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
//public class GlobalSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	
////	private final UserService userService;
////	
////    @Autowired
////    public WebSecurityConfig(UserService userService) {
////        this.userService = userService;
////    }
//	
//	
//	@Autowired
//    private UserDetailsService userDetailsService;
//
//
//	@Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//                .antMatchers("/", "/home", "/src/main/webapp/**")
//                	.permitAll()
//                .antMatchers("/","/resources/**")
//                	.permitAll()
//                .antMatchers("/connect", "/**").hasAnyAuthority("ADMIN", "DBA", "USER")
//                //.antMatchers("/connect", "/**").access("ADMIN and DBA and USER")
//                //.antMatchers("/connect", "/**").access("hasRole('ADMIN') and hasRole('DBA') and hasRole('USER')")
//            .and()
//            .formLogin()
//                .loginPage("/loginDesign")
//                .failureUrl("/loginDesign?error")
//                .usernameParameter("email")
//                .passwordParameter("password")
////                .loginProcessingUrl("/connect")
////                .permitAll()
//                .loginProcessingUrl("connect")
//                .and()
//                .csrf()
//                .disable()
//            .logout()
//            	.logoutUrl("/logout")
//                .permitAll();
//    }
//	
//    @Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService);
//	}	
//}
//
