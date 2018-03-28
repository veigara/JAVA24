<%@page import="com.hxzy.entity.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.hxzy.biz.impl.StudentBizImpl"%>
<%@page import="com.hxzy.biz.StudentBiz"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生列表</title>
<link rel="stylesheet" href="static/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" href="static/bootstrap/css/bootstrap-theme.css" />
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
<script src="static/bootstrap/js/bootstrap.js"></script>
<script src="static/js/html5shiv.js"></script>
</head>
<body>
	<main class="container">
		<button class="btn btn-success">添加学生</button>
		<table class="table table-striped table-bordered table-hover table-condensed">
			<thead>
				<tr>
					<th>学号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>登录名</th>
				</tr>
			</thead>
			<tbody>
				<%
				StudentBiz biz = new StudentBizImpl(); //引用学生的业务逻辑层
				List<Student> list = biz.query(null);//查询全部学生
				
				for(Student stu:list){
				%>
				<tr>
					<td><%=stu.getStuNo() %></td>
					<td><%=stu.getStuName() %></td>
					<td><%=stu.getSex() %></td>
					<td><%=stu.getIdentityCard()%></td>
				</tr>	
			<%	
				}
			%>
			</tbody>
		</table>
	</main>
</body>
</html>