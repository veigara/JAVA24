package com.hxzy.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/responseServlet")
public class ResponseServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//实现页面跳转
		/*
		 * 1.页面转发
		 * 2.重定向
		 * */
		//在url地址栏中输入http://127.0.0.1:8080/Servlet01/responseServlet
		//直接重定向到login.html
		response.sendRedirect("login.html");//重定向就相当于在url中输入了http://127.0.0.1:8080/Servlet01/login.html
		//response.sendRedirect("/login.html");// 如果地址加了/ ，代表访问webapps中ROOT目录里面的login.html   /代表ROOT
	}

	
}
