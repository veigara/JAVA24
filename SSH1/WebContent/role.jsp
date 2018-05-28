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
 <table id="dg" title="角色信息" class="easyui-datagrid" 
       style="width:100%;height:100%"
            url="${pageContext.request.contextPath}/queryRole.action"
            toolbar="#toolbar" pagination="true"  pageList="[1,2,3,5]" 
            pageSize="2"
            rownumbers="true" fitColumns="true" singleSelect="true">
        <thead>
            <tr>
                <th field="roleId" width="50">角色编号</th>
                <th field="roleName" width="50">角色名称</th>
            </tr>
        </thead>
    </table>
    <div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">添加角色</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">修改角色</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">删除角色</a>
    </div>
    
    <div id="dlg" class="easyui-dialog" style="width:400px" 
       data-options="closed:true,modal:true,border:'thin',
         buttons:'#dlg-buttons'">
        <form id="fm" method="post" novalidate 
            style="margin:0;padding:20px 50px">
            <h3>角色信息</h3>
            <div style="margin-bottom:10px">
                <input name="roleName" class="easyui-textbox" required="true" label="角色名称：" style="width:100%">
            </div>
            
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width:90px">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
    </div>
    <script type="text/javascript">
        var url;
        function newUser(){
            $('#dlg').dialog('open').dialog('center').dialog('setTitle','添加角色');
            $('#fm').form('clear');
            url = '${pageContext.request.contextPath}/addRole.action';
        }
        function editUser(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $('#dlg').dialog('open').dialog('center').dialog('setTitle','Edit User');
                $('#fm').form('load',row);
                url = 'update_user.php?id='+row.id;
            }
        }
        function saveUser(){
            $('#fm').form('submit',{
                url: url,
                onSubmit: function(){
                    return $(this).form('validate');
                },
                success: function(result){
                    var result = eval('('+result+')');
                    if (!result.flag){
                        $.messager.show({
                            title: 'Error',
                            msg: result.message
                        });
                    } else {
                        $('#dlg').dialog('close');        // close the dialog
                        $('#dg').datagrid('reload');    // reload the user data
                    }
                }
            });
        }
        function destroyUser(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $.messager.confirm('Confirm','Are you sure you want to destroy this user?',function(r){
                    if (r){
                        $.post('destroy_user.php',{id:row.id},function(result){
                            if (result.success){
                                $('#dg').datagrid('reload');    // reload the user data
                            } else {
                                $.messager.show({    // show error message
                                    title: 'Error',
                                    msg: result.errorMsg
                                });
                            }
                        },'json');
                    }
                });
            }
        }
    </script>




</body>
</html>