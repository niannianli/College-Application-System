package com.college.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.dao.UserDao;

@Service
public class RegisterService {
	
	// no need to create object with new keyword,
	// user direclty
	// same object used again and again
	// no matter how many times it is used
	
	// Object is already created by SPring when you use 
	//@Repostity, @Controller, @Service, @Component
	
	// you just use @Autowired to invoke the created, singleton object
	// and use it here
	@Autowired
	private UserDao userDao;
}
