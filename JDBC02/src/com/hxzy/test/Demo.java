package com.hxzy.test;

import java.util.Date;

public class Demo {
	private String name;
	private int age;
	private Date date;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Demo(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Demo() {
		super();
	}
	@Override
	public String toString() {
		return "Demo [name=" + name + ", age=" + age + ", date=" + date + "]";
	}
}
