package com.oded.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oded.model.User;

public interface UserRepo extends JpaRepository<User,Integer> {
	
 User	findByUsername(String username);

}
