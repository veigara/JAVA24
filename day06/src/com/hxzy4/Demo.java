package com.hxzy4;

public class Demo {
	/*
	 * 一列数的规则如下: 1、1、2、3、5、8、13、21、34...... 求第30位数是多少， 用递归算法实现
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
