package com.college.dao;

import java.util.List;

import com.college.pojo.RoleMenuMapping;
import com.college.pojo.User;
import com.college.pojo.UserRoleMapping;

public interface RoleDao {
	 public User findMenuByRoleId(Integer roleId);

	public List<UserRoleMapping> findRoleIdsByUserId(Integer id);

	public List<RoleMenuMapping> findMenusByRoleId(Integer id);
}
