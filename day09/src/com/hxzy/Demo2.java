package com.hxzy;

public class Demo2 {

	public int methodOne(int param1) {
		
		return param1 * param1;
	}
	
	public void methodOne(int param1,int param2) {
		int num1 = param1 * param1;
		int num2 = (int) Math.pow(param2, 2);
		System.out.println("param1��ƽ����" + num1);
		System.out.println("param2��ƽ����" + num2);
	}
	
	/**
	 * 
	 * @param num ��һ���ַ������͵�����    "123"  "345"  "1.23"   "abc" "hello"
	 * @return
	 */
	public int methodOne(String str) {
		//���ַ������͵�����ת����Ϊint������double
		//int num1 = (int)num; //��ΪString����ֵ���Ͳ����ݣ����Բ������Զ�����ת����ǿ������ת��
		
		//ʹ�û����������͵İ�װ��
		/*
		 * int,double�����������ͣ�������������û�з���
		 * java���ṩ�˺ܶ����װ��
		 * int--->java.lang.Integer
		 * double--->java.lang.Double
		 * */
		int maxValue = Integer.MAX_VALUE;//2^31 -1
		int minValue = Integer.MIN_VALUE;//-2^31
		int num = Integer.valueOf(str);//���ַ�������ת����ΪInteger
		return num * num;
	}
	
	public static void main(String[] args) {
		int i = 100869;//01000
		System.out.println(Integer.toBinaryString(i));//��int���͵�ֵת����Ϊ�ַ����Ķ�����
		System.out.println(Integer.toHexString(i));//��int���͵�ֵת����Ϊ�ַ�����ʮ������
		
		/*
		 * Integer.valueOf()��Integer.parseInt()������
		 * */
		System.out.println();
		String str = "abc";
		int num = Integer.valueOf(str);
		int num2 = Integer.parseInt(str);
		//System.out.println("Integer.valueOf:" + num);
		System.out.println("Integer.parseInt" + num2);
	}
}
