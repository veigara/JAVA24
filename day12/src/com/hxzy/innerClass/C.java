package com.hxzy.innerClass;

import java.util.HashMap;

import com.hxzy.innerClass.A.B;

public class C {

	/*
	 * ��C���з���A���е��ڲ���B
	 * 
	 * B��Ϊ���⿪��
	 * */
	public static void main(String[] args) {
		/*A a = new A();
		B b = a.new B();
		b.setNum(10);
		System.out.println(b.getNum());*/
		B b = new A().new B();//ʵ�����ڲ���Ĳ���
		
		HashMap<String, String> map = new HashMap<>();
	}
	
}
