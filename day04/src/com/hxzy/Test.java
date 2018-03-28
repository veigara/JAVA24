package com.hxzy;

public class Test {

	public static void main(String[] args) {
		int a = 5; //0101
		int b = 4; //0100
		
		//判断两个数字是否相等
		/*if ((a ^ b) == 0) {
			
		}*/
		
		//通过异或也可以实现两个数的交换
		a = a ^ b;//0001    ==> 1
		b = b ^ a;//0101
		a = a ^ b;//0100
	}

}
