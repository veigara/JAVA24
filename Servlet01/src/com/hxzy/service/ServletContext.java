package com.hxzy.service;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetAllServlets
 */
@WebServlet("/servletContext")
public class ServletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private javax.servlet.ServletContext context;
	
    @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.context = config.getServletContext();
	}

	public ServletContext() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, ? extends ServletRegistration> r = this.context.getServletRegistrations();
		System.out.println("所有的注册Servlet信息");
		for (String key : r.keySet()) {
			ServletRegistration servletRegistration = r.get(key);
			System.out.println(servletRegistration.getName());
		}
	}


}
