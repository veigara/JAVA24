package com.hxzy.interfacedemo;

/**
 * 司机的接口
 * @author Administrator
 *
 */
public interface DriverInterface {
	/*
	 * 1.接口使用interface修饰 
	 * 2.接口代表的是一种能力
	 * 3.接口中的方法都是抽象方法
	 * 4.接口中的变量都是静态常量
	 * 
	 * 使用接口的好处
	 * 1.子类可以实现多个接口，但是一个类只能继承一个父类
	 * 2.设计和实现完全分离
	 * 3.更自然的使用多态
	 * 4.基于接口可以搭建程序框架
	 * 5.更容易更换实现
	 * 6.面向接口编程
	 * */
	public void drive();
}
