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
		String method = request.getMethod();//��ȡ����ʽ
		String uri = request.getRequestURI();//��ȡ�����URL��ַ
		String query = request.getQueryString();//��ȡurl�в�������
		String protocol = request.getProtocol();//Э��汾   HTTP 1.1
		String contentPath = request.getContextPath();	//��Դ·��
		String servletPath = request.getServletPath(); //servlet����
		
		System.out.println("method:" + method);
		System.out.println("uri:" + uri);
		System.out.println("query:" + query);
		System.out.println("protocol:" + protocol);
		System.out.println("contentPath:" + contentPath);
		System.out.println("servletPath:" + servletPath);
		
		System.out.println("------------------------------");
		String ip = request.getRemoteAddr();//��ȡ����Ŀͻ���ip��ַ
		String host = request.getRemoteHost();//��������Ŀͻ���������
		int port = request.getRemotePort();//�˿ں�
		
		String localIp = request.getLocalAddr();//���������ip��ַ
		String localHost = request.getLocalName();//���������������
		int localPort = request.getLocalPort();//��������Ķ˿ں� 
		String serverName = request.getServerName();//��ǰ����ָ���������
		int serverPort = request.getServerPort();//��ǰ���������Ķ˿ں�
		String scheme = request.getScheme();//��ȡЭ��   http,https
		String requestUrl = request.getRequestURL().toString();//��ȡ������url��ַ
		
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
		
		String contentType = request.getContentType(); //��ȡ�������MIME
		System.out.println("contentType:" + contentType);
		
		String character = request.getCharacterEncoding();//��ȡ����ı��뷽ʽ
		System.out.println("character:" + character);
	}

	
}
