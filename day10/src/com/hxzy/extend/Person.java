package com.hxzy.extend;

import java.util.Date;

public class Person {
	
	/**
	 * �ڸ������ṩ��һ���вι��췽��
	 * @param name
	 * @param age
	 * @param birthDate
	 */
	public Person(String name,int age,Date birthDate) {
		this.name = name;
		this.age = age;
		this.birthDate = birthDate;
	}
	
	public Person() {
		super();
	}

	public String name;
	public int age;
	public Date birthDate;
	
	public String getInfo() {
		return null;
	}
	
	private void test() {
		
	}
}
