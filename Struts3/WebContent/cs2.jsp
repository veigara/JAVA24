<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
request.setAttribute("myDate",new Date());  
%>


<s:date name="#request.myDate" format="yyyy--MM--dd" var="sdate"/>  
<br>  
格式化后的日期：<s:property value="#sdate"/>  
<br/>  
<s:textfield name="username" label="用户名" key="Switch"/> 
<br>
  <s:radio name="gender" list="#{'0':'男','1':'女'}" label="性别" value="1" />  

<br>
<s:select name="city" 
   list="#{'bj':'北京','sh':'上海','gz':'广州','sz':'深圳'}" 
   label="城市" headerKey="-1" headerValue="---请选择城市---" 
   emptyOption="false"/>  
<br>
<s:checkboxlist name="hibbies" list="#{'code':'写代码','algorithm':'算法','movie':'电影'}" 
label="爱好" value="code"/>

<br>
  <s:checkbox name="married" label="是否已婚" value="false" labelposition="left"/>  
<br>
<s:file name="phone" label="头像"/>  

</body>
</html>