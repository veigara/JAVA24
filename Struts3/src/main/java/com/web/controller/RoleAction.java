package com.web.controller;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.web.entity.Role;

public class RoleAction extends ActionSupport {

	List<Role> roleList = new ArrayList<Role>();
	
	@Override
	public String execute() throws Exception {
		
		roleList.add(new Role(1,"管理员"));
		roleList.add(new Role(2,"会员"));
		roleList.add(new Role(3,"普通用户"));
		
		return SUCCESS;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	
	
}
