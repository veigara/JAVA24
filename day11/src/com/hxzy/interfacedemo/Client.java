package com.hxzy.interfacedemo;

public class Client {
	public static void main(String[] args) {
		
		//�������ͣ���������
		Person p = new Worker();
		p.setName("");
		
		DriverInterface driver = new Worker();
		driver.drive();
		
		CookerInterface cooker = new Worker();
		cooker.cook();
		
		System.out.println();
	}
}
