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
</head>
<body>
<ul id="leftTree" class="ztree"></ul>
<a id="checkAllTrue" href="#" >勾选</a>
<a id="checkAllFalse" href="#">取消勾选</a>

<script type="text/javascript">
    var setting = {
        check:{
            enable:true
        },
        view: {
            showLine: true,//显示节点之间的连线。
            selectedMulti: false  //允许同时选中多个节点。
        },
        data: {
            simpleData: {
                enable:true, //使用简单数据模式
                idKey: "id",//节点数据中保存唯一标识的属性名称
                pIdKey: "pId",//节点数据中保存其父节点唯一标识的属性名称
                rootPId: "" //用于修正根节点父节点数据 默认值：null
            }
        } 
    };
    var nodes = [
        {id :"1",pId:"0",name :"山西省"},
        {id :"2",pId:"0",name : "河北省"},
        {id :"3",pId:"0",name : "内蒙省"},
        {id :"4",pId:"0",name : "吉林省"},
        {id :"11",pId:"1",name: "大同市"},
        {id :"12",pId:"1",name: "朔州市"},
        {id :"21",pId:"2",name: "石家庄"},
        {id :"22",pId:"2",name: "唐山市"},
        {id :"31",pId:"3",name: "赤峰市"},
        {id :"32",pId:"3",name: "呼市"},
        {id :"41",pId:"4",name: "长春市"},
        {id :"42",pId:"4",name: "四平市"},
        {id :"43",pId:"4",name: "辽源市"},
        {id :"111",pId:"11",name:"浑源县"},
        {id :"112",pId:"11",name: "阳高县"},
        {id :"121",pId:"12",name: "山阴县"},
        {id :"122",pId:"12",name: "应县"}
    ];
    var tree  = $.fn.zTree.init($('#leftTree'), setting, nodes);
    tree.expandAll(tree);
    function checkNode(e) {
        var zTree = $.fn.zTree.getZTreeObj("leftTree"),
                type = e.data.type,
                nodes = zTree.getSelectedNodes();
        console.log(type.indexOf("All"));
        if (type.indexOf("All") < 0 && nodes.length == 0) {
            alert("请先选择一个节点");
        }
        if (type == "checkAllTrue") {
            zTree.checkAllNodes(true);
        } else if (type == "checkAllFalse") {
            zTree.checkAllNodes(false);
        }
    }
    $("#checkAllTrue").bind("click", { type: "checkAllTrue" }, checkNode);
    $("#checkAllFalse").bind("click", { type: "checkAllFalse" }, checkNode);
    var zTreeObj = $.fn.zTree.getZTreeObj("leftTree"); //那个树对象
            console.log(zTreeObj);
            var nodes = zTreeObj.transformToArray(zTreeObj.getNodes());
            console.log(nodes);

</script>
</body>
</html>