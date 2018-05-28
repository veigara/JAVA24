package com.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.web.entity.Admin;


@Namespace("")
@ParentPackage("json-default")
public class AdminAction extends ActionSupport {

	List<Admin> adminList = new ArrayList<>();
	
	
	@Action(value="queryAdmins",results={@Result(name="success",type="json"
			,params={"root","adminList"})})
	public String queryAdmin() throws Exception{
		
		adminList.add(new Admin(1, "张三", "123", "男", 28));
		adminList.add(new Admin(2, "张三2", "123", "男", 28));
		adminList.add(new Admin(3, "张三3", "123", "男", 28));
		adminList.add(new Admin(4, "张三4", "123", "男", 28));
		adminList.add(new Admin(5, "张三5", "123", "男", 28));
		adminList.add(new Admin(6, "张三6", "123", "男", 28));
		adminList.add(new Admin(7, "张三7", "123", "男", 28));
		
		return SUCCESS;
	}
	
	public List<Admin> getAdminList() {
		return adminList;
	}




	public void setAdminList(List<Admin> adminList) {
		this.adminList = adminList;
	}
}
