<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html lang="utf-8">
<head>

<title>后台管理系统登录</title>
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<jsp:include page="../common/commoncss.jsp"></jsp:include>
 
<style type="text/css">
body {
	background: #F5F5F5;
}
#page-wrapper {
    padding: 7em 2em 2.5em;
    background-color: #F1F1F1;
    margin-top: -60px;
}
</style>
</head>

<body>
 <div class="main-content">
       <div id="page-wrapper" style="min-height: 243px;">
             <div class="main-page login-page ">
					<div class="widget-shadow">
									<div class="login-top">
										<h1>欢迎进入权限管理系统</h1>
									</div>
									<div class="login-body">
										<form action="${pageContext.request.contextPath }/login.do" method="post">
											<input type="text" id="loginName" class="user" name="loginName" placeholder="输入用户名" required="">
											<input type="password" id="loginPwd" name="loginPwd" class="lock" placeholder="输入密码">
											<input type="text" id="code" name="code" class="user" placeholder="输入验证码">
											<img src="${pageContext.request.contextPath }/code.do"
													data-url="${pageContext.request.contextPath }/code.do"
													id="imgObj" title="看不清，点击刷新" />
											
											<input type="submit" name="Sign In" value="登录">
											<div class="forgot-grid">
												<label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>Remember me</label>
												<div class="forgot">
													<a href="#">forgot password?</a>
												</div>
												<div class="clearfix"> </div>
											</div>
										</form>
									</div>
								</div>
					</div>	
		   </div>
	</div>
 <!-- jQuery -->
<%@ include file="../common/commonjs.jsp" %>
<script type="text/javascript">
	 $(function(){
		  $("#imgObj").click(function(){
			  var url = $(this).attr("data-url");
			  
			  var timestamp = (new Date()).valueOf();
			  
			  var srcUrl = url + "?stime="+timestamp;
			  
			  
			  $(this).attr("src",srcUrl);
		  })
	 })
   
</script>
</body>
</html>
