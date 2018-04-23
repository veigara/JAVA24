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
<script
type="text/javascript">
        var zTree;

        var setting = {
           //复选框
       		check:{
                   enable:true
               },
            //视图
            view: {
                   showLine: true,//显示节点之间的连线。
                   selectedMulti: false  //允许同时选中多个节点。
               },
             //异步
            async: {
                enable: true,
                url:"${pageContext.request.contextPath}/admin/getMenu.do",
                autoParam:["id=pid"]
            },

            //回调函数
            callback:{
                beforeClick:function(treeId,treeNode){
                	alert(treeNode.name);
                	
                	//通过点击文字 选中复选框
                	zTree.checkNode(treeNode, !treeNode.checked, true); 
                	
                    if(treeNode.isParent){
                        zTree.expandNode(treeNode);
                        return true;
                    }
                    return false;
                }
            }
        };

        //加载事件
        $(function(){
            zTree = $.fn.zTree.init($("#tree"), setting);
        });

    </script>
</head>
<body>
  <ul id="tree" class="ztree"></ul>
</body>
</html>