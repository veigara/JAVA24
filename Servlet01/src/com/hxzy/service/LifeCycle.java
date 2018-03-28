package com.hxzy.service;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class LifeCycle
 */
public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServletContext context;
	/**
	 * 初始化Servlet的方法，在第一次访问LifeCycle时只会执行一次，并且获取Servlet初始化参数对象ServletConfig
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("ServletConfig初始化完毕");
		//String encoding = config.getInitParameter("encoding");
		//System.out.println("Servlet初始化参数为：" + encoding);
		Enumeration<String> params = config.getInitParameterNames();
		while (params.hasMoreElements()) {	//循环遍历初始化参数数
			String key = params.nextElement();
			String value = config.getInitParameter(key);
			System.out.println("初始化参数：" + key + ":" + value);
		}
		context = config.getServletContext(); //通过config获取LifeCycle对应的上下文环境
	}

	/**
	 * 初始化Servlet的方法，在第一次访问LifeCycle时只会执行一次
	 */
	@Override
	public void init() throws ServletException {
		System.out.println("Servlet初始化完毕");
	}
	
	/**
	 * Servlet核心方法，每次执行Servlet，都会调用service方法
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("service方法被执行");
		String className = this.context.getInitParameter("className");
		System.out.println("班级名称：" + className);
		
		//向上下文环境中添加属性
		this.context.setAttribute("userName", "明玉");
	}

	/**
	 * 在Tomcat正常关闭时，会执行一次销毁方法
	 */
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("销毁Servlet");
	}

	
	
}
