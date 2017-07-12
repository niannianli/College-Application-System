package com.college.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.college.pojo.Menu;
import com.college.service.LoginService;
import com.college.vo.LoginFormBean;

// invoke service
// like servlet
// object created by SPring
@Controller
public class LoginController {
	// name is controller
	// but is actullay model function

	// value assigned without new keyword, just use it directly
	@Autowired
	private LoginService loginService;

	//if reequest url is .../login.html, this method is executed
	@RequestMapping(value = "/login.html")
	public String goToLoginPage(Model model) {

		// must inititate object,
		// but value can be ignoed
		// will get value from form anyway
		LoginFormBean loginFormBean = new LoginFormBean();
		loginFormBean.setUsername("root");
		loginFormBean.setPassword("root");
		model.addAttribute("loginFormBean", loginFormBean);

		// no need to create any servlet
		return "login.jsp";
	}

	// if i submit the form, action is /dologin.html
	// this url is requested
	// and mapped to this method
	// htis method is called
	// same object with differnt values now
	@RequestMapping(value = "/dologin.html", method = RequestMethod.POST)
	public String validateUser(Model model, @ModelAttribute("loginFormBean") LoginFormBean loginFormBean)
			throws SQLException {
		// public String validateUser(@RequestParam("username") String username
		// @RequestParam("password") String password){
		// SERVLET: request.get

		// SPRING: annoataion the same
		
		Boolean status = loginService.isValidUser(loginFormBean.getUsername(), loginFormBean.getPassword());

		if (status) {
			List<Menu> menuList = loginService.getMenusByUsername(loginFormBean.getUsername());
			
			// model = request
			// connect to jsp, show menuList on jsp page
			model.addAttribute("menuList", menuList);

			return "dashboard.jsp";
		} else {
			return "login.jsp";
		}

	}

}

// create db in mysql workbench
//ERD forward engineering

// log4j: check error:

// servelt, jsp: each servlet mapping to url
// spring mvc: does everything for us

// controller: servlet: DispatcherServlet: Front Controller: one handles all
// configure, then its done, no code writtern by developers
//home reg dash: all urls go to DispatcherServlet

// redirects to 3 models:3 methods: which noted/annotated as controller in
// spring mvc: Controller

// final generates view, html/jsp/tiles/VM/

// response to users

// if you have 30 pages, 30 servlets needed
// if spring, once for all.: no need to use
// request.getParameter() to get all data in form for objects

// you also need to create object and assign the data you get
// for the object

// lots of servlets, lots of objects

// spring mvc makes it so much easier

// servlet once for all
// form is attached to one object
// use annotation
// form data is assigned to object directly

// Model object:
// inside model object we have form object
// where all form data will be assigned automatically
// form mapped to class: in form tag: modelAttribute="Class"
// data assigned to Class object automitically
// wihout you create the object manually

// spring tag: not html tag
// cssClass="form-control"
// no need to use name=""
// instead path="username"

// Login Controller: model: request methods()
// Registraction Controller: model: request methods()

// Spring hibernate

// dispatacher-servlet.xml: define location/package of Controller
// any Controller class in the package location
// spring uses
// @Controller to create singleton LoginController object

// service
// dao

// @Controller, , @Service, @Repository
// all the same
// @Component super annotation of all annotation

// @Autowired: inject object to value

// Spring with hibernate

// session, restful web service

// jquery, javascript,

// validation

// deploy application
// war file

// set up java-home: jdk
// set up catalina home: tomcat
// add to PATH

// choose war file, and click on Deploy

// start

// click on name
// working...

// or:
// copy war file to webapp
// start tomcat server
// type web addresss: done

// cat ~/.bashrc

// set variables

// svn
// how to set up svn on mac?

// <--get update
// -->commit

// configure svn in eclipse

// team: update/commit

// version control

// rest application: how, jquery,

// EOB

// Person: name, address, teleno
// Student:
// Teacher:

// : is a relationship

// now we want to delete address in Person class

// we have to change Student/Teacher too now

// ?

// : has a relationship is better

// inject Person inside Student/Teacher
// whenever there is change in Person
// none will be affected in Stduent/Teacher

// locanization: Spring
// internalzation: Spring

// 2 languages

// 2 property files

// use spring bean to configure/retrieve

// pom.xml:

// spring 4.3.9release version
// servelrt: 3.0.1version
// spring core, bean, context,
// web webmvc

// spring-orm: ocnnect db

// mysql
// hibernate core 4.3.11

// commons-dbcp

// web.xml:
// DispatcherServlet

// dispatcher-servlet.xml: controller class folder/package
// bean: dataSrouce, sessionFactory

// @Controller

// user type: A, C, T, S
// insert data first

// Admin:

// Menu table
// active or deactivate user: Admin
// change role: changeRole.html: Admin
// collect money: collectMoney.html: Cashier
// assign batches: assignBatches.html: Teacher
// list of batchers: listOfBatches.html: Student

// insert 4 datas: each for each role

// now Role table:
// 4 types of role:
// id role_name, created_by,, crated_date, mod_by, mod_date
// A, C, T, S

// if User login as Admin user type
// only 2 datas in Menu table will be shown:
// active user, change rule

// Role_Menu_Mapping Table:
// role_id, menu_id, id
// 1, 1
// 1, 2
// ...

// Teacher:

// Cashier:

// Student:

// edit db data:
// give 2 menus to role A
// ...

// give 2 menu to role S

// give User 3 roles

// User table: delete_falg: N default

// if you deactive user, delete_falg: Y
// but data is not delted, not labeld as delted

// add it everywhere

// logically delete

// Batch Table
