package com.hxzy.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hxzy.biz.StudentBiz;
import com.hxzy.biz.impl.StudentBizImpl;
import com.hxzy.entity.Student;

@WebServlet("/queryAllStudents")
public class QueryAllStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private StudentBiz biz = new StudentBizImpl(); //引用学生的业务逻辑层
	
    public QueryAllStudentsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> list = biz.query(null);//查询全部学生
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("<title>学生列表</title>");
		out.print("<link rel=\"stylesheet\" href=\"static/bootstrap/css/bootstrap.css\" />\r\n" + 
				"<link rel=\"stylesheet\" href=\"static/bootstrap/css/bootstrap-theme.css\" />\r\n" + 
				"<script src=\"https://cdn.bootcss.com/jquery/3.3.1/jquery.js\"></script>\r\n" + 
				"<script src=\"static/bootstrap/js/bootstrap.js\"></script>\r\n" + 
				"<script src=\"static/js/html5shiv.js\"></script>\r\n" + 
				"</head><body>");
		out.print("<main class=\"container\">");
		out.print("<button class=\"btn btn-success\">添加学生</button>");
		out.print("<table class=\"table table-striped table-bordered table-hover table-condensed\">");
		out.print("<thead>");
		out.print("<tr>");
		out.print("<th>学号</th>");
		out.print("<th>姓名</th>");
		out.print("<th>性别</th>");
		out.print("<th>登录名</th>");
		out.print("</tr>");
		out.print("</thead>");
		
		out.print("<tbody>");
		
		for (Student stu : list) {
			out.print("<tr>");
			out.print("<td>" + stu.getStuNo() + "</td>");
			out.print("<td>" + stu.getStuName() + "</td>");
			out.print("<td>" + stu.getSex() + "</td>");
			out.print("<td>" + stu.getIdentityCard() + "</td>");
			out.print("</tr>");
		}
		
		out.print("</tbody>");
		out.print("\r\n" + 
				"		</table>\r\n" + 
				"	</main>\r\n" + 
				"</body>\r\n" + 
				"</html>");
		out.flush();
		out.close();
	}

}
