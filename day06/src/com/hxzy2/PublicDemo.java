package com.hxzy2;

public class PublicDemo {
	public String stuName;//属性，成员变量
	
	/**
	 * 调用了这个方法以后，会为本类中的stuName属性赋值
	 * @param stuName
	 */
	public void setName(String stuName) {
		//int num = 10;//局部变量
		this.stuName = stuName;//为本类的对象的stuName属性
	}
}
