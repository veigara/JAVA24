package com.hxzy.extend;

import java.util.Date;

public class Person {
	
	/**
	 * 在父类中提供了一个有参构造方法
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
