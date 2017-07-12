package com.college.dao;

import java.sql.SQLException;

import com.college.pojo.User;

public interface UserDao {
	
	public User findUserByUsernameAndPassword(String username, String password) throws SQLException;
	
	public User findUserByUsername(String username);

}
