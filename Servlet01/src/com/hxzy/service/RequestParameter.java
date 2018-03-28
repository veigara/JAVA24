package com.hxzy.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestParameter extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置请求域的编码方式
		request.setCharacterEncoding("utf-8");
		String user = request.getParameter("user");//获取request请求域url的参数
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		System.out.println("user:" + user);
		System.out.println("name:" + name);
		System.out.println("pwd:" + pwd);
		
		//http://127.0.0.1:8080/Servlet01/requestServlet?user=admin&pwd=123&name=张三
		request.getParameterNames();//queryString 中键的集合   {user,pwd,name}
		
		/*
		 * 单选框由多个name相同的input type="radio"组成页面组件
		 * 复选框由多个name相同的input type="checkbox"组成页面组件
		 * */
		request.getParameterValues("hobby");//针对表单中单选框，复选框而使用
		
		request.setAttribute("user", user);//在request作用域中存储一个键值
		Object value = request.getAttribute("user");	//在request作用域中根据键取值
	}

	
}
