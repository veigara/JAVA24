package com.web.controller;

import com.opensymphony.xwork2.ActionSupport;

public class UserController extends ActionSupport {
	
	/**
	 * 属性的getter，setter方法
	 */
	private String username;
	private String password;

	
	/**
	 * Spring MVC:String,void,ModelAndView
	 * Struts2:String  返回页面的名称（不是实际页面的名称）
	 */
	@Override
	public String execute() throws Exception {
		
		if("admin".equals(username) && "123".equals(password)){
			return SUCCESS;//"success"
		}
		
		return LOGIN;//"login"
	}
	
	public String register() throws Exception{
		
		
		return SUCCESS;
	}
	
	public String update() throws Exception{
		
		return SUCCESS;
	}
	
	public String add() throws Exception{
		
		return SUCCESS;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
