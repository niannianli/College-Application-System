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
public class Menu {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="menu_name")
	private String menuName;
	@Column(name="menu_url")
	private String menuUrl;
	
	@OneToMany(mappedBy="menu")	
	private List<RoleMenuMapping> listRoles;
	
	public List<RoleMenuMapping> getListRoles() {
		return listRoles;
	}
	public void setListRoles(List<RoleMenuMapping> listRoles) {
		this.listRoles = listRoles;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}	
}
