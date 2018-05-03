package com.web.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.web.entity.User;

/**
 * 传递参数:
 * 2、对象的getter，setter
 * @author xxq
 *
 */
public class LoginController1 extends ActionSupport {
	
	private User user;

	@Override
	public String execute() throws Exception {
		
		
		if("admin".equals(user.getUsername()) && "123".equals(user.getPassword())){
			return SUCCESS;//"success"
		}
		
		return LOGIN;//"login"
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
