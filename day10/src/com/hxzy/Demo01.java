package com.hxzy;

public class Demo01 {

	/*
	 * static���ε����Ի򷽷���������Ķ���,ͨ�����������ԣ��������㷽������
	 * ��static���ε����Ի򷽷�������ص�������֮�����Ѿ��������ڴ��С�
	 * 
	 * */
	public static String str = "hello";
	public static void aaa() {
		
	}
	
	static{
		/*��̬�����*/
		System.out.println("ִ���˾�̬����������");
	}
	
	{
		/*��������
		 *���������ִ��ʱ�����ڹ��췽�� 
		 * */
		System.out.println("ִ���˹��������еĴ���");
	}
	
	public Demo01(){
		System.out.println("Demo01�Ĺ��췽��");
	}
	
	
	public void test() {
		int a = 5;
		/*�ֲ������*/
		{
			System.out.println("ִ�оֲ�����������");
		}
		
	}
	
	public static void main(String[] args) {
		//Demo01 d = new Demo01();
		//d.test();
		
		//����static���ε����Ի򷽷�
		//String str = Demo01.str;
		//Demo01.aaa();
	}
}
