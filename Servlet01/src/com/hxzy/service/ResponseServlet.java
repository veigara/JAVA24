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
		//ʵ��ҳ����ת
		/*
		 * 1.ҳ��ת��
		 * 2.�ض���
		 * */
		//��url��ַ��������http://127.0.0.1:8080/Servlet01/responseServlet
		//ֱ���ض���login.html
		response.sendRedirect("login.html");//�ض�����൱����url��������http://127.0.0.1:8080/Servlet01/login.html
		//response.sendRedirect("/login.html");// �����ַ����/ ���������webapps��ROOTĿ¼�����login.html   /����ROOT
	}

	
}
