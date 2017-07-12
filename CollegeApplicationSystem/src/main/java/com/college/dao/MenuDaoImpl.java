package com.college.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.college.pojo.Menu;

@Repository
public class MenuDaoImpl {
		
		@Autowired
		SessionFactory  sessionFactory;
		
		public Menu findMenuById(Integer id){
			Session session = sessionFactory.getCurrentSession();
			return (Menu) session.get(Menu.class, id);
			
			}
}
