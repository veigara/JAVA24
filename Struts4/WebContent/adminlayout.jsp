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
<body  class="easyui-layout">

<div data-options="region:'north'" style="height:50px">
上面
</div>


<div data-options="region:'south',split:true"  style="height:50px;">
   底部
</div>

<div data-options="region:'east',split:true" title="East" style="width:100px;">
  右边
</div>

<div data-options="region:'west',split:true" title="West" style="width:100px;">
 左边
</div>

<div data-options="region:'center',title:'Main Title',iconCls:'icon-ok'">
	<table class="easyui-datagrid"
			data-options="url:'${pageContext.request.contextPath}/queryAdmin.action',method:'get',border:false,singleSelect:true,
			fit:true,fitColumns:true,pagination:true, pageList: [1, 2, 3,5]" >
		<thead>
			<tr>
				<th data-options="field:'adminId'" width="80">用户编号</th>
				<th data-options="field:'adminName'" width="100">用户名</th>
				<th data-options="field:'adminPwd',align:'right'" width="80">密码</th>
				<th data-options="field:'sex',align:'right'" width="80">性别</th>
				<th data-options="field:'age'" width="150">年龄</th>
			</tr>
		</thead>
	</table>
</div>

</body>
</html>