package com.web.controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.web.entity.User;

/**
 * 传参数  3、实现模型驱动
 * @author xxq
 *
 */
public class UserController2 implements Action,ModelDriven<User>{
	
	User user = new User();

	@Override
	public String execute() throws Exception {
		if("admin".equals(user.getUsername()) && "123".equals(user.getPassword())){
			return SUCCESS;
		}
		return LOGIN;
	}

	@Override
	public User getModel() {
		
		return user;
	}

}
