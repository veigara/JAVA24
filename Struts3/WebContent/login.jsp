<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="/struts-tags"  prefix="s" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="login.action" method="post" >
 用户名:<input type="text" name="username"><font color="red"><s:fielderror fieldName="username"></s:fielderror></font><br>
 密码:<input type="text" name="password"><font color="red"><s:fielderror fieldName="password"></s:fielderror></font><br>
 <input type="submit" value="登录">
</form>
</body>
</html>