package com.hxzy.extend2;

public class SubClass extends SuperClass{

	static {
		System.out.println("����ľ�̬����鱻ִ��");
	}
	
	{
		System.out.println("����Ĺ������鱻ִ��");
	}
	
	public SubClass() {
		/*
		 * ʵ�����������ʱ������Ĺ��췽��Ĭ�ϻ���ø�����޲ι��췽��
		 * */
		System.out.println("ִ��������Ĺ��췽��");
	}
}
