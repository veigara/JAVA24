$(function(){
	 
	//全选，反选
	$("input[level='1']").click(function(){
		
		$("input[level!='1']").prop('checked',$(this).prop('checked'));
	})
	
	
	//二级菜单的全选，反选
	$("input[level='2']").click(function(){
		
		//$("input[level='3']").prop('checked',$(this).prop('checked'));
		
		$(this).parents("dl").find("input[level='3']").prop('checked',$(this).prop('checked'));
	})
})