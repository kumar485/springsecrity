/**
 * 
 */
package com.oded.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oded.dao.UserRepo;
import com.oded.model.User;

/**
 * @author KUKI
 *
 */
@RestController
public class UserController {
	@Autowired
	private UserRepo repo;
	@GetMapping("/testone")
	public String test1() {
		return "TEST ONE";
	}
	@GetMapping("/testtwo")
	public String test2() {
		return "TEST TWO";
	}
	@GetMapping("/users")
	public List<User> allUsers() {
		return repo.findAll();
	}
	

}
