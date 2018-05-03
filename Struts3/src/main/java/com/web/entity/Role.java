package com.web.entity;

import java.io.Serializable;

public class Role implements Serializable {

	private Integer roleId;
	private String roleName;
	
	public Role() {
		// TODO Auto-generated constructor stub
	}
	
	public Role(Integer roleId,String roleName) {
		this.roleId = roleId;
		this.roleName = roleName;
	}
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
