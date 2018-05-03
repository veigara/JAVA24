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
<s:form action="upload.action" method="post" enctype="multipart/form-data">
 <s:file name="myFile"  label="文件:"></s:file><br>
 <s:submit value="上传"></s:submit>
</s:form>

<a href="down.action?fileName=${myFileFileName }"><img alt="" src="upload/${myFileFileName }" width="300" height="300"></a>






</body>
</html>