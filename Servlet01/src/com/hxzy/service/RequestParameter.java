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
		
		//����������ı��뷽ʽ
		request.setCharacterEncoding("utf-8");
		String user = request.getParameter("user");//��ȡrequest������url�Ĳ���
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		System.out.println("user:" + user);
		System.out.println("name:" + name);
		System.out.println("pwd:" + pwd);
		
		//http://127.0.0.1:8080/Servlet01/requestServlet?user=admin&pwd=123&name=����
		request.getParameterNames();//queryString �м��ļ���   {user,pwd,name}
		
		/*
		 * ��ѡ���ɶ��name��ͬ��input type="radio"���ҳ�����
		 * ��ѡ���ɶ��name��ͬ��input type="checkbox"���ҳ�����
		 * */
		request.getParameterValues("hobby");//��Ա��е�ѡ�򣬸�ѡ���ʹ��
		
		request.setAttribute("user", user);//��request�������д洢һ����ֵ
		Object value = request.getAttribute("user");	//��request�������и��ݼ�ȡֵ
	}

	
}
