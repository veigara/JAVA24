package com.hxzy4;

public class Demo {
	/*
	 * һ�����Ĺ�������: 1��1��2��3��5��8��13��21��34...... ���30λ���Ƕ��٣� �õݹ��㷨ʵ��
	 * */
	
	public int recursion(int a,int b,int index) {
		
		a = a + b;//1,2,3,5
		b = a - b;//1,1,2,3
		
		if (index++ == 30) {
			return b;
		}
		return recursion(a,b,index);
	}
	
	public static void main(String[] args) {
		Demo demo = new Demo();
		
		int a = 1;
		int b = 0;
		
		int num = demo.recursion(a,b,0);
		System.out.println(num);
	}
}
