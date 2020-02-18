package com.oded.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.oded.dao.UserRepo;
import com.oded.model.User;
@Service
public class CustomUserService implements UserDetailsService {
@Autowired
private UserRepo repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = repo.findByUsername(username);
		
		SpringUser us=new SpringUser(user);
		return us;
		
	}

}
