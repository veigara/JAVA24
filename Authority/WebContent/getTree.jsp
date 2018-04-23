<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugin/ztree/css/zTreeStyle/zTreeStyle.css"> 
<script src="${pageContext.request.contextPath}/plugin/ztree/js/jquery-1.4.4.min.js"></script>
<script src="${pageContext.request.contextPath}/plugin/ztree/js/jquery.ztree.all.min.js"></script>
<script type="text/javascript">
       
        var setting={
        		view: {
        		    dblClickExpand: true,//双击节点时，是否自动展开父节点的标识
        		    showLine: true,//是否显示节点之间的连线
        		    fontCss:{'color':'black','font-weight':'bold'},//字体样式函数
        		    selectedMulti: true //设置是否允许同时选中多个节点
        		  },
        		check: {
        			enable: true,
        			chkStyle: "checkbox",
        			chkboxType: { "Y": "p", "N": "s" }
        		},
        		async:{
        			enable:true,
        			url:"${pageContext.request.contextPath}/admin/getMenuTree.do"
        		},
        		callback:{
        			beforeClick:function(treeId,treeNode){
        				
        				//alert(treeNode.name);
        			}
        		}
        		
        }

 
		$(document).ready(function(){
		    zTreeObj = $.fn.zTree.init($("#treeNode"), setting);
		 });
</script>
</head>
<body>

<ul id="treeNode" class="ztree"></ul>

</body>
</html>