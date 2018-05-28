package com.web.controller;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.web.entity.Admin;
import com.web.pojo.EasyuiResult;

public class AdminController extends ActionSupport {
	
	EasyuiResult<Admin> easyResult = new EasyuiResult<>();
	


	
	public String query() throws Exception{
		easyResult.setTotal(7);
		
		List<Admin> rows = new ArrayList<Admin>();
		rows.add(new Admin(1, "张三", "123", "男", 28));
		rows.add(new Admin(2, "张三2", "123", "男", 28));
		rows.add(new Admin(3, "张三3", "123", "男", 28));
		rows.add(new Admin(4, "张三4", "123", "男", 28));
		rows.add(new Admin(5, "张三5", "123", "男", 28));
		rows.add(new Admin(6, "张三6", "123", "男", 28));
		rows.add(new Admin(7, "张三7", "123", "男", 28));
		
		easyResult.setRows(rows);
		
		return SUCCESS;
	}
	



	public EasyuiResult<Admin> getEasyResult() {
		return easyResult;
	}


	public void setEasyResult(EasyuiResult<Admin> easyResult) {
		this.easyResult = easyResult;
	}





	
	
}
