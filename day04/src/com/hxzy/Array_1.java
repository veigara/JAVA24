package com.hxzy;

public class Array_1 {

	public static void main(String[] args) {
		int[] arr1;//������һ��int���͵�����
		int arr2[];
		
		//��̬��ʼ������,��ϵͳΪ�����е�ÿ��Ԫ��ָ��Ĭ��ֵ
		/*
		 * byte   0
		 * short  0
		 * int    0
		 * long   0
		 * flaot  0.0f
		 * double 0.0
		 * char   \u0000
		 * String null
		 * 
		 * */
		arr1 = new int[5];
		
		System.out.println(arr1[0]);
		
		int[] arr3 = new int[5];//�������飬������ռ�
		
		//��̬��ʼ������,����ĳ����ɳ�ʼ�������ֵĸ�������
		int[] arr4 = {98,5,67,35};
		int[] arr5 = new int[] {98,5,67,35};
		
		System.out.println(arr5);
	}

}
