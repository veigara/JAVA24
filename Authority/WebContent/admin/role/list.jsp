<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <%@ include file="../../common/commoncss.jsp" %>
<%@ include file="../../common/commonjs.jsp" %>
 
<script type="text/javascript">
     $(function(){
    	  $(".pagination a").click(function(){
    		    var page = $(this).attr("pdata");
    		    
    		    //给隐藏框赋值
    		    $("#myPage").val(page);
    		    
    		    //表单提交
    		    $("#myForm").submit();
    	  }) 
     })
</script>
</head>
<body>
<form action="${pageContext.request.contextPath }/admin/pagingRole.do" class="form-horizontal" method="post" id="myForm">

  
<div class="container">
           <div class="control-group">
                   <label class="control-label" for="focusedInput">角色名称:</label>
                    <input class="input-xlarge focused" id="focusedInput" type="text" name="roleName" value="${roleName }">
             <button type="submit" class="btn btn-primary">查询</button>
                     <button type="reset" class="btn">取消</button>
                     <input type="button" value="导出" id="outExcel">
             </div>

			<div class="col-lg-12">
			<div>&nbsp;</div>
				<div class="myTable col-sm-12 ">
					<table class="table">
						<tr><td colspan="7" class="center">角色信息页面</td></tr>
						<tr>
								<td>角色编号</td>
								<td>角色名称</td>
								<td>操作</td>
						</tr>
						<c:forEach items="${paging.data }" var="p">
					      <tr>
					         <td>${p.roleId }</td>
					         <td>${p.roleName }</td>
					         <td><a href="${pageContext.request.contextPath }/admin/sendAuthority.do?roleId=${p.roleId }">分配权限</a>  删除</td>
					      </tr>
					   </c:forEach>	
					</table>
				</div>
				 ${paging.navigation }
			</div>
	</div>
	<div style="display: none;">
    <iframe id="excelFrame" width="0" height="0"></iframe>
</div>
</form>
<%@ include file="../../common/commonjs.jsp" %>
<script type="text/javascript">
  $(function(){
	  //导出excel
	  $("#outExcel").click(function(){
		  
		  var url = "${pageContext.request.contextPath }/admin/excelRole.do";
		   
		  $("#excelFrame").attr("src",url);//自动的访问后台
	  })
  })
</script>
</body>
</html>