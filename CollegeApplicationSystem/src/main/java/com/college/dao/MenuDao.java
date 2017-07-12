package com.college.dao;

import java.util.List;

import com.college.pojo.Menu;

public interface MenuDao {
	public Menu findMenuById(Integer id);

	public List<Menu> findMenusById(Integer id);
}
