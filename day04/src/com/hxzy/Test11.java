package com.hxzy;

public class Test11 {

	/*
	 * ʹ��java�������1000�� ��Χ�� -50000~50000����������Ȼͳ��ÿ��������ֳ��ֵĴ�����Ҫ��ʱ����10���������
	 * */
	public static void main(String[] args) {
		int[] arr = new int[100000];//��̬����
		
		long begin = System.currentTimeMillis();
		
		//Ϊ���鸳ֵ
		for (int i = 0; i < 1000; i++) {
			int ran = (int)(Math.random() * 100000);
			arr[ran] = arr[ran] + 1;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				System.out.print("����" + (i - 50000) + "������" + arr[i] + "��\t");
			}
		}
		
		System.out.println("����5������Ϊ��");
		int count = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] != 0) {
				System.out.println(i - 50000);
				count++;
				if (count == 5) {
					break;
				}
			}
		}
		
		long end = System.currentTimeMillis();
		long time = end - begin;
		System.out.println("\n�ܹ���ʱ:" + time);
	}

}
