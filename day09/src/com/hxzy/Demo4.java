package com.hxzy;

public class Demo4 {
	public static void main(String[] args) {
		//test1();
		test2();
	}

	/*
	 * ʵ��Ϊ������������
	 * */
	private static void test1() {
		int num = 5;//������������
		change(num);//��num�ĸ������ݽ�change����
		System.out.println(num);
	}
	
	private static void change(int num) {
		num = 3;
		System.out.println(num);
	}
	
	/*
	 * ʵ��Ϊ������������ 
	 */
	private static void test2() {
		Num n = new Num();
		System.out.println("Num��ֵ��" + n.num);
		
		change(n);//ʵ��Ϊһ�������������ͣ�һ������
		
		System.out.println("Num��ֵ��" + n.num);
	}
	
	private static void change(Num num) {
		num.num = 3;
		System.out.println("Num��ֵ��" + num.num);
	}
}
