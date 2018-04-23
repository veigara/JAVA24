<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/plugin/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
 <script type="text/javascript" src="${pageContext.request.contextPath}/plugin/ztree/js/jquery-1.4.4.min.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath}/plugin/ztree/js/jquery.ztree.core.js"></script>
<script type="text/javascript">
		var zTreeObj;
		// zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
		var setting = {
				 view: {
					    dblClickExpand: false,//双击节点时，是否自动展开父节点的标识
					    showLine: true,//是否显示节点之间的连线
					    fontCss:{'color':'black','font-weight':'bold'},//字体样式函数
					    selectedMulti: false //设置是否允许同时选中多个节点
					  },
					  check:{
						    //chkboxType: { "Y": "ps", "N": "ps" },
						    chkStyle: "checkbox",//复选框类型
						    enable: true //每个节点上是否显示 CheckBox 
						  },
						  data: {
							    simpleData: {//简单数据模式
							      enable:true,
							      idKey: "id",
							      pIdKey: "pId",
							      rootPId: ""
							    }
							  },
						  callback: {
						    beforeClick: function(treeId, treeNode) {
						      zTree = $.fn.zTree.getZTreeObj("user_tree");
						      if (treeNode.isParent) {
						        zTree.expandNode(treeNode);//如果是父节点，则展开该节点
						      }else{
						        zTree.checkNode(treeNode, !treeNode.checked, true, true);//单击勾选，再次单击取消勾选
						      }
						    }
						  }
				
		};
		// zTree 的数据属性，深入使用请参考 API 文档（zTreeNode 节点数据详解）
		var zNodes = [
		{name:"test1", open:true, children:[
		   {name:"test1_1"}, {name:"test1_2"}]},
		{name:"test2", open:true, children:[
		   {name:"test2_1"}, {name:"test2_2"}]}
		];
		$(document).ready(function(){
		   zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
		});

</script>

</head>
<body>
<div>
   <ul id="treeDemo" class="ztree"></ul>
</div>
</body>
</html>