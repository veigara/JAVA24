package com.hxzy.service;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ServletContext context;
	
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.context = config.getServletContext();//通过config获取上下文环境
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		 String method = request.getMethod();
		 System.out.println("请求方式：" + method);
		System.out.println("欢迎访问HelloServlet");
		
		String className = context.getInitParameter("className");
		System.out.println("班级名称：" + className);
		
		String userName = (String) this.context.getAttribute("userName");
		System.out.println("用户名：" + userName);
		this.context.removeAttribute("userName");//从上下文环境中移除属性
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String loginName = req.getParameter("loginName");
		String loginPwd = req.getParameter("loginPwd");
		String method = req.getMethod();
		System.out.println("请求方式：" + method);
		System.out.println("登录名：" + loginName);
		System.out.println("登录密码：" + loginPwd);
	}

	
	
}
