package com.hxzy;

public class Demo3 {

	/**
	 * ����һ���вη����������б�Ϊһ��int���͵�����
	 * @param arr
	 */
	public void test(int[] arr) {
		
	}
	
	private void test1() {
		int[] arr = {99,88,77,66};
		test(arr);
		
		/*
		 * �ɱ䳤�Ȳ����б�ķ����ĵ���
		 * 
		 * */
		test2(arr); //����int���͵�����
		test2();  //�������κβ���
		test2(2,3,5,6,9);//�������������int���͵Ĳ���
		
		//test2("");
		//test2("",1,2,3,4,5);
	}
	
	/*
	 * �����ɱ䳤�ȵĲ����б�ķ���ʱ���ɱ䳤�Ȳ�������ŵ������б��ĩβ
	 * test(String str,int...params)
	 * test(int num1,int...params)
	 * 
	 * ��ʹ�ÿɱ䳤�Ȳ����б�ʱ���Ͱ�������һ����ͨ�������þ�ok�ˣ�������Ҫ�ж���������Ƿ�Ϊ��
	 * */
	public void test2(int...a) {
		if (a != null) {
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i] + "\t");
			}
			System.out.println();
		}
	}
	
	public void test2(String a,int...params) {}
	
	public static void main(String[] args) {
		Demo3 demo3 = new Demo3();
		demo3.test1();
	}
}
