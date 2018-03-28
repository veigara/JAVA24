package com.hxzy.service;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod();//获取请求方式
		String uri = request.getRequestURI();//获取请求的URL地址
		String query = request.getQueryString();//获取url中参数部分
		String protocol = request.getProtocol();//协议版本   HTTP 1.1
		String contentPath = request.getContextPath();	//资源路径
		String servletPath = request.getServletPath(); //servlet名称
		
		System.out.println("method:" + method);
		System.out.println("uri:" + uri);
		System.out.println("query:" + query);
		System.out.println("protocol:" + protocol);
		System.out.println("contentPath:" + contentPath);
		System.out.println("servletPath:" + servletPath);
		
		System.out.println("------------------------------");
		String ip = request.getRemoteAddr();//获取请求的客户的ip地址
		String host = request.getRemoteHost();//发出请求的客户机主机名
		int port = request.getRemotePort();//端口号
		
		String localIp = request.getLocalAddr();//接收请求的ip地址
		String localHost = request.getLocalName();//接收请求的主机名
		int localPort = request.getLocalPort();//接收请求的端口号 
		String serverName = request.getServerName();//当前请求指向的主机名
		int serverPort = request.getServerPort();//当前请求主机的端口号
		String scheme = request.getScheme();//获取协议   http,https
		String requestUrl = request.getRequestURL().toString();//获取完整的url地址
		
		System.out.println("ip:" + ip);
		System.out.println("host:" + host);
		System.out.println("port:" + port);
		System.out.println("localIp:" + localIp);
		System.out.println("localHost:" + localHost);
		System.out.println("localPort:" + localPort);
		System.out.println("serverName:" + serverName);
		System.out.println("serverPort:" + serverPort);
		System.out.println("scheme:" + scheme);
		System.out.println("requestUrl:" + requestUrl);
		System.out.println();
		Enumeration<String> headerNames = request.getHeaderNames();
		System.out.println("headName\theader");
		while (headerNames.hasMoreElements()) {
			String name = headerNames.nextElement();
			String header = request.getHeader(name);
			System.out.println(name + "\t" + header);
		}
		
		String contentType = request.getContentType(); //获取请求提的MIME
		System.out.println("contentType:" + contentType);
		
		String character = request.getCharacterEncoding();//获取请求的编码方式
		System.out.println("character:" + character);
	}

	
}
