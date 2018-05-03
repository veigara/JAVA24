<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib  uri="/struts-tags" prefix="s"%>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<s:iterator value="roleList" var="r" status="ss">
<s:if test="#ss.odd">
角色id:${r.roleId }
 <font color="red">角色名称：<s:property value="#r.roleName"/>  </font>
 </s:if>
 <s:else>
 角色id:${r.roleId }
 角色名称：${r.roleName }
 </s:else>
 <hr>
</s:iterator>
<s:debug/>  
</body>
</html>