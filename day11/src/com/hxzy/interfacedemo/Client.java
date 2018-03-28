package com.hxzy.interfacedemo;

public class Client {
	public static void main(String[] args) {
		
		//父类类型，子类引用
		Person p = new Worker();
		p.setName("");
		
		DriverInterface driver = new Worker();
		driver.drive();
		
		CookerInterface cooker = new Worker();
		cooker.cook();
		
		System.out.println();
	}
}
