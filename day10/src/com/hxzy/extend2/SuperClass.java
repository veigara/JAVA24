package com.hxzy.extend2;

public class SuperClass {
	
	static {
		System.out.println("����ľ�̬����鱻ִ��");
	}
	
	{
		System.out.println("����Ĺ������鱻ִ��");
	}
	
	public SuperClass() {
		System.out.println("ִ���˸���Ĺ��췽��");
	}
	
	public SuperClass(String name) {}
}
