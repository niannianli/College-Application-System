package com.college.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.college.pojo.User;

//url request-->Controller-->Service-->DAO

//connect db, handle db
// DB only

// all beans will be created too
// you can use @Autowired to call the object
// to be used

// object created
@Repository
public class UserDaoImpl implements UserDao{
	
	// Spring will create this object for you, okay.once for all.
	
	// valued assinged, use directly,  is inserted to the variable
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private DataSource dataSource;
	
	
	public User findUserByUsernameAndPassword(String username, String password) throws SQLException{
		
		// hibernate/jdbc code		
	//	Connection conn = dataSource.getConnection();
		
		Session session = null;
		
		try{
		session = sessionFactory.openSession();
		Query query = session.createQuery("from user where username = :param1 and password = :param2");
		query.setParameter("param1", "nian");
		query.setParameter("param2", "nian");	
		User user = (User) query.uniqueResult();
			
			return user;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}

	@Override
	public User findUserByUsername(String username) {
		return null;
	}
	
}
