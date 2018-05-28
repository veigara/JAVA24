package com.web.entity;

import java.io.Serializable;

public class Admin implements Serializable {

	private Integer adminId;
	private String adminName;
	private String adminPwd;
	private String sex;
	private Integer age;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	
	public Admin(Integer adminId, String adminName, String adminPwd,
			String sex, Integer age) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPwd = adminPwd;
		this.sex = sex;
		this.age = age;
	}



	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPwd() {
		return adminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}
