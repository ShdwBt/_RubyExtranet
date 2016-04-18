//package com.rubyExtranet;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//@Configuration
////HibernateJpaAutoConfiguration
////@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
//@ComponentScan
////@SpringBootApplication
//public class ExtranetApplication extends WebMvcConfigurerAdapter{
//
//	public static void main(String[] args) {
//		SpringApplication.run(ExtranetApplication.class, args);
//	}
//	
//	@Value("${spring.datasource.driver-class-name}")
//    private String databaseDriverClassName;
// 
//    @Value("${spring.datasource.url}")
//    private String datasourceUrl;
// 
//    @Value("${spring.datasource.username}")
//    private String databaseUsername;
// 
//    @Value("${spring.datasource.password}")
//    private String databasePassword;
//    
//    @Bean
//    public DataSource datasource() {
//        org.apache.tomcat.jdbc.pool.DataSource ds = new org.apache.tomcat.jdbc.pool.DataSource();
//        ds.setDriverClassName(databaseDriverClassName);
//        ds.setUrl(datasourceUrl);
//        ds.setUsername(databaseUsername);
//        ds.setPassword(databasePassword);
// 
//        return ds;
//    }
//    
//    @Override  
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {  
//            registry.addResourceHandler("/resources/**").addResourceLocations("/resources/"); 
//            
//    }  
//}