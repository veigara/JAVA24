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
			data-options="url:'datagrid_data1.json',method:'get',border:false,singleSelect:true,
			fit:true,fitColumns:true">
		<thead>
			<tr>
				<th data-options="field:'itemid'" width="80">Item ID</th>
				<th data-options="field:'productid'" width="100">Product ID</th>
				<th data-options="field:'listprice',align:'right'" width="80">List Price</th>
				<th data-options="field:'unitcost',align:'right'" width="80">Unit Cost</th>
				<th data-options="field:'attr1'" width="150">Attribute</th>
				<th data-options="field:'status',align:'center'" width="60">Status</th>
			</tr>
		</thead>
	</table>
</div>

</body>
</html>