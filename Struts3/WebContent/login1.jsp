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
<s:form action="login.action" method="post" theme="simple">
 用户名:<s:textfield name="username"></s:textfield><font color="red"><s:fielderror fieldName="username"></s:fielderror></font><br>
 密码:<s:textfield name="password"></s:textfield><font color="red"><s:fielderror fieldName="password"></s:fielderror></font><br>
 <s:submit value="登录"></s:submit>
</s:form>

</body>
</html>