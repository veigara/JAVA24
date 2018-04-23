<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../../common/commoncss.jsp" %>
<!-- Bootstrap Core CSS -->
<link href="${pageContext.request.contextPath }/css/authority.css" rel='stylesheet' type='text/css' />

<%@ include file="../../common/commonjs.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/authority.js"></script>
</head>
<body>
<form action="${pageContext.request.contextPath }/admin/saveAuthority.do" method="post">

   <input type="hidden" value="${roleId }" name="roleId">
	<div class="container-widget">
				<div class="container-padding">
				  <!-- Start Row -->
				  <div class="row">
				    <div class="col-md-12">
				      <div class="panel panel-default">
				        <div class="panel-title">
				          	管理员--分配权限信息
				        </div>
							   <div class="panel-body">
					                <div id="roleprivlieges">
											<dl class="app">
												<p class="approot">
													<b>后台管理(全选)</b>  
													<input type="checkbox" name="cks" value="0" level="1">
												</p>
												  <c:forEach items="${list }" var="m1">
														<div class="clearfix">
															<dl class="clearfix">
															  
																<b>${m1.menuName }</b> 
																
																<input type="checkbox" name="accesse" value="${m1.menuId }" level="2" <c:if test="${m1.authority == true }">checked="checked"</c:if>>
															</dl>
															     <c:forEach items="${m1.childMenu }" var="m2">
																	<dt>
																		<span>${m2.menuName }</span> 
																        <input type="checkbox" name="accesse" value="${m2.menuId }" level="3" <c:if test="${m2.authority == true }">checked="checked"</c:if>>
																	</dt> 
																	
																	 <c:forEach items="${m2.childMenu }" var="m3">
																	     <dd>
																	            <span>${m3.menuName }</span> 
																	             <input type="checkbox" name="accesse" value="${m3.menuId }" level="4" <c:if test="${m3.authority == true }">checked="checked"</c:if>>
																	     </dd>
																	 </c:forEach>
																</c:forEach>
														</div> 
													</c:forEach>
											</div>
									 </div>
						              <div class="form-group">
													<div class="col-md-12 text-center">
														<input class="btn btn-primary" type="submit" value="保存">
													</div>
										 </div>
						       </div>
					   </div>
	            </div>
	        </div>
	      </div>
	    </div>
</form>   
</body>
</html>