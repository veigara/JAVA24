package com.hxzy.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hxzy.biz.StudentBiz;
import com.hxzy.biz.impl.StudentBizImpl;
import com.hxzy.entity.Student;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private StudentBiz biz = new StudentBizImpl();
    public LoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*设置编码方式*/
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//从请求作用域中获取登录名和密码
		String loginName = request.getParameter("loginName");
		String loginPwd = request.getParameter("loginPwd");
		
		Student stu = biz.login(loginName, loginPwd);
		if (stu != null) { //用户名和密码正确
			 //跳转到查询所有学生的Servlet
			response.sendRedirect("queryAllStudents");
		} else {//用户名或密码有误
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('用户名或密码错误！');window.location.href='login.html';</script>");
		}
	}

}
