package com.hxzy;

public class Test {

	public static void main(String[] args) {
		int a = 5; //0101
		int b = 4; //0100
		
		//�ж����������Ƿ����
		/*if ((a ^ b) == 0) {
			
		}*/
		
		//ͨ�����Ҳ����ʵ���������Ľ���
		a = a ^ b;//0001    ==> 1
		b = b ^ a;//0101
		a = a ^ b;//0100
	}

}
