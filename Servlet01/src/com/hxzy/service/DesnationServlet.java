package com.hxzy.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DesnationServlet
 */
@WebServlet("/desnationServlet")
public class DesnationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DesnationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		//设置响应的MIME
		response.setContentType("text/html");//响应HTML
		String user = (String) request.getAttribute("user");
		PrintWriter out = response.getWriter();//通过输出流向页面输出内容
		out.write("用户名：<strong style='color:red;'>" + user + "</strong>");
		out.flush();
		out.close();
	}


}
