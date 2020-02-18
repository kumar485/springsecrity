/**
 * 
 */
package com.oded.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.oded.dao.UserRepo;
import com.oded.model.User;
@Service
public class DB implements CommandLineRunner {
@Autowired
  private UserRepo repo;
@Autowired
private PasswordEncoder encoder;
	@Override
	public void run(String... args) throws Exception {
		System.err.println("executing");
		User kumar=new User(1,"user",encoder.encode("user"));
		User admin=new User(2,"admin",encoder.encode("admin"));
		List<User> asList = Arrays.asList(kumar,admin);
		
		repo.saveAll(asList);
		
	}

}
