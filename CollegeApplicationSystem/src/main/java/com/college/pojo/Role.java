package com.college.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="menu")
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="role_name")
	private String roleName;
	
	@OneToMany(mappedBy="role")
	private List<RoleMenuMapping> listMenus;
	
	@OneToMany(mappedBy="role")
	private List<UserRoleMapping> listUsers;
	
	public List<RoleMenuMapping> getListMenus() {
		return listMenus;
	}
	public void setListMenus(List<RoleMenuMapping> listMenus) {
		this.listMenus = listMenus;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}	

}
