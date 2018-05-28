<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/plugin/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/plugin/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/plugin/demo.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/plugin/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/plugin/jquery.easyui.min.js"></script>

</head>
<body>
<div style="margin:20px 0;">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#language').combobox('reload', 'combobox_data1.json')">LoadData</a>
	</div>
 
<input class="easyui-combobox" id="language" name="language"
		data-options="valueField:'id',textField:'text'"><br>
		
<input class="easyui-combobox" id="language" name="language"
		data-options="url:'${pageContext.request.contextPath}/queryAdmins.action',
					method:'get',
					valueField:'adminId',
					textField:'adminName'">
</body>
</html>