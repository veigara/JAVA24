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
		this.context = config.getServletContext();//ͨ��config��ȡ�����Ļ���
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		 String method = request.getMethod();
		 System.out.println("����ʽ��" + method);
		System.out.println("��ӭ����HelloServlet");
		
		String className = context.getInitParameter("className");
		System.out.println("�༶���ƣ�" + className);
		
		String userName = (String) this.context.getAttribute("userName");
		System.out.println("�û�����" + userName);
		this.context.removeAttribute("userName");//�������Ļ������Ƴ�����
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String loginName = req.getParameter("loginName");
		String loginPwd = req.getParameter("loginPwd");
		String method = req.getMethod();
		System.out.println("����ʽ��" + method);
		System.out.println("��¼����" + loginName);
		System.out.println("��¼���룺" + loginPwd);
	}

	
	
}
