<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="${pageContext.request.contextPath }/plugin/kindeditor/themes/default/default.css" />
		<script src="${pageContext.request.contextPath }/plugin/kindeditor/kindeditor.js"></script>
		<script src="${pageContext.request.contextPath }/plugin/kindeditor/lang/zh_CN.js"></script>

		<script>
			KindEditor.ready(function(K) {
				var editor = K.editor({
					allowFileManager : true
				});
				K('#image1').click(function() {
					editor.loadPlugin('image', function() {
						editor.plugin.imageDialog({
							imageUrl : K('#url1').val(),
							clickFn : function(url, title, width, height, border, align) {
								K('#url1').val(url);
								editor.hideDialog();
							}
						});
					});
				});
			})
</script>			
</head>
<body>

<p><input type="text" id="url1" value="" /> <input type="button" id="image1" value="选择图片" />（网络图片 + 本地上传）</p>

</body>
</html>