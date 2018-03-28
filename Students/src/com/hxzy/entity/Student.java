package com.hxzy.entity;

import java.io.Serializable;

/**
 * 学生表的实体类
 * @author Administrator
 *
 */
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int stuNo;
	private String loginPwd;
	private String stuName;
	private String sex;
	private String identityCard;
	
	/**
	 * 获取学号
	 * @return
	 */
	public int getStuNo() {
		return stuNo;
	}
	/**
	 * 设置学号
	 * @param stuNo int类型的学号
	 */
	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}
	
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getIdentityCard() {
		return identityCard;
	}
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identityCard == null) ? 0 : identityCard.hashCode());
		result = prime * result + stuNo;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (identityCard == null) {
			if (other.identityCard != null)
				return false;
		} else if (!identityCard.equals(other.identityCard))
			return false;
		if (stuNo != other.stuNo)
			return false;
		return true;
	}
	public Student(int stuNo, String loginPwd, String stuName, String sex, String identityCard) {
		super();
		this.stuNo = stuNo;
		this.loginPwd = loginPwd;
		this.stuName = stuName;
		this.sex = sex;
		this.identityCard = identityCard;
	}
	public Student() {
		super();
	}
	
	
}
