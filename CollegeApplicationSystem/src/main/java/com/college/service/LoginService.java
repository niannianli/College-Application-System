package com.college.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.dao.MenuDao;
import com.college.dao.RoleDao;
import com.college.dao.UserDao;
import com.college.dao.UserDaoImpl;
import com.college.pojo.Menu;
import com.college.pojo.RoleMenuMapping;
import com.college.pojo.User;
import com.college.pojo.UserRoleMapping;

//Business logic only
// invoke db, dao

// object created
@Service
public class LoginService {
// business logic
	
	// valued assigned to object, use it directly
	//override
	
	// we are injecting interface UserDao, but UserDaoImpl will be used
	// becasue override
	// UserDao userDao = new UserDaoImpl();
	// automatically provide userDaoImpl;
	
	// so this single object.
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private MenuDao menuDao;
	
	public Boolean isValidUser(String username, String password) throws SQLException{
		
		// generate web.xml
		// add DispatcherServlet, datasource, sessionFactory
		
		if(username.length()<0){
			return false;
		}else{	
		User user = (User)userDao.findUserByUsernameAndPassword(username, password);	
				if(user==null){
					return false;
				}else{
					return true;
				}
	}
}
	
	
	public List<Menu> getMenusByUsername(String username){
	
		User user = userDao.findUserByUsername(username);
		
		List<UserRoleMapping> roleIds = roleDao.findRoleIdsByUserId(user.getId());
		
		List<Menu> menus = null;
		
		for(UserRoleMapping userRoleMapping : roleIds){
			
			List<RoleMenuMapping> menuIds = roleDao.findMenusByRoleId(userRoleMapping.getRole().getId());
			
			for(RoleMenuMapping roleMenuMapping : menuIds){
				
				menus = menuDao.findMenusById(roleMenuMapping.getMenu().getId());
			}
		}
	
		return menus;
					
	}
}

// create a project using spring mvc
//design db first

//employee table
//apply leave: insert into leave table;
//leave table

//one-many
//employee-address
//annotation

//functions:
//design: abstract classes, interface

//Dao: 
// db methods are all here
