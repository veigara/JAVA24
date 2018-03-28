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
	 * ��ʼ��Servlet�ķ������ڵ�һ�η���LifeCycleʱֻ��ִ��һ�Σ����һ�ȡServlet��ʼ����������ServletConfig
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("ServletConfig��ʼ�����");
		//String encoding = config.getInitParameter("encoding");
		//System.out.println("Servlet��ʼ������Ϊ��" + encoding);
		Enumeration<String> params = config.getInitParameterNames();
		while (params.hasMoreElements()) {	//ѭ��������ʼ��������
			String key = params.nextElement();
			String value = config.getInitParameter(key);
			System.out.println("��ʼ��������" + key + ":" + value);
		}
		context = config.getServletContext(); //ͨ��config��ȡLifeCycle��Ӧ�������Ļ���
	}

	/**
	 * ��ʼ��Servlet�ķ������ڵ�һ�η���LifeCycleʱֻ��ִ��һ��
	 */
	@Override
	public void init() throws ServletException {
		System.out.println("Servlet��ʼ�����");
	}
	
	/**
	 * Servlet���ķ�����ÿ��ִ��Servlet���������service����
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("service������ִ��");
		String className = this.context.getInitParameter("className");
		System.out.println("�༶���ƣ�" + className);
		
		//�������Ļ������������
		this.context.setAttribute("userName", "����");
	}

	/**
	 * ��Tomcat�����ر�ʱ����ִ��һ�����ٷ���
	 */
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("����Servlet");
	}

	
	
}
