<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%@ include file="../../common/commoncss.jsp" %>
<%@ include file="../../common/commonjs.jsp" %>
 <link rel="stylesheet" href="${pageContext.request.contextPath }/plugin/kindeditor/themes/default/default.css" />

</head>
<body>
     <form class="form-horizontal" action="${pageContext.request.contextPath }/admin/addMenu.do" method="post">
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label">菜单名称：</label>
			<div class="col-sm-4">
				<input type="text" name="menuName" class="form-control1" id="focusedinput" placeholder="请输入菜单名称">
			</div>
		</div>
		
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label">父级菜单：</label>
			<div class="col-sm-4">
			    <select class="form-control" name="parentId">
			        <option value="0">请选择</option>
			        <c:forEach items="${list }" var="one">
			           <option value="${one.menuId }">${one.menuName }</option>
			           
			           <!-- 第二层 -->
			           <c:forEach items="${one.childMenu }" var="two">
			               <option value="${two.menuId }" style="margin-left: 30px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${two.menuName }</option>
			               
			               <!-- 第三层 -->
			               <c:forEach items="${two.childMenu }" var="three">
			                    <option value="${three.menuId }" style="margin-left: 30px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${three.menuName }</option>
			               </c:forEach>
			           </c:forEach>
			        </c:forEach>
			     
               </select>
			</div>
		</div>
		
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label">菜单图标：</label>
			<div class="col-sm-4">
				<input type="text" id="imageUrl" value="" name="menuImage"/> 
				<input type="button" id="image1" value="选择图片" />（网络图片 + 本地上传)
			</div>
		</div>
		
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label">菜单排序：</label>
			<div class="col-sm-4">
				<input type="text" name="menuOrder" class="form-control1" id="focusedinput" placeholder="请输入菜单排序">
			</div>
		</div>
		
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label">菜单访问路径：</label>
			<div class="col-sm-4">
				<input type="text" name="menuUrl" class="form-control1" id="focusedinput" placeholder="请输入菜单访问路径">
			</div>
		</div>
		
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label"></label>
			<div class="col-sm-4">
				<input type="submit"  class="form-control1"  value="添加">
			</div>
		</div>
   </form>
  <script src="${pageContext.request.contextPath }/plugin/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath }/plugin/kindeditor/kindeditor.js"></script>
<script src="${pageContext.request.contextPath }/plugin/kindeditor/lang/zh_CN.js"></script>

<script type="text/javascript">

		KindEditor.ready(function(K) {
			var editor = K.editor({
				allowFileManager : true
			});
			K('#image1').click(function() {
				editor.loadPlugin('image', function() {
					editor.plugin.imageDialog({
						imageUrl : K('#imageUrl').val(),
						clickFn : function(url, title, width, height, border, align) {
							K('#imageUrl').val(url);
							editor.hideDialog();
						}
					});
				});
			});
		});
</script>
</body>
</html>