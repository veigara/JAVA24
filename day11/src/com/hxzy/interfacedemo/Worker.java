package com.hxzy.interfacedemo;

/**
 * 这是一个特殊的工人类
 * 具备开车，做饭的能力
 * @author Administrator
 *
 */
public class Worker extends Person implements DriverInterface,CookerInterface{

	public void test() {
		System.out.println("test");
	}
	
	@Override
	public void cook() {
		System.out.println(super.getName() + "会做饭");
	}

	@Override
	public void drive() {
		System.out.println(super.getName() + "会开车");
	}

	public static void main(String[] args) {
		Worker worker = new Worker();
		worker.setName("张三");
		worker.cook();
		worker.drive();
	}
}
