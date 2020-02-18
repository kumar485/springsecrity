/**
 * 
 */
package com.oded.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.oded.service.CustomUserService;

/**
 * @author KUKI
 *
 */
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private CustomUserService service;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		/*
		 * auth.inMemoryAuthentication().withUser("user")
		 * .password(getEncoder().encode("user")).roles("USER") .and()
		 * .withUser("admin") .password(getEncoder().encode("admin")).roles("ADMIN")
		 * .and() .withUser("manager")
		 * .password(getEncoder().encode("manager")).roles("MANAGER");
		 */
		 auth.authenticationProvider(daoProvider());
		
	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 http.authorizeRequests()
         .antMatchers().permitAll()
         .anyRequest().authenticated()
         .and()
         .httpBasic();
	}
	
	@Bean
	public PasswordEncoder getEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	protected
	UserDetailsService userDetailsService() {
		return new CustomUserService();
	}
	
	DaoAuthenticationProvider daoProvider() {
		DaoAuthenticationProvider dao=new DaoAuthenticationProvider();
		dao.setPasswordEncoder(getEncoder());
		dao.setUserDetailsService(service);
		
		return dao;
		
	}

}
