package com.hxzy;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		//����һ���̶��������飬ͨ�������Ϊ���鸳ֵ
		int[] arr = new int[100000];//��̬��ʼ������
		
		//��������������ַ�ʽ��1
		/*Random ran = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = ran.nextInt(1000) + 1; //�������1-1000�������
		}*/
		//2.Math.random()   double   0-1С��
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 1000);
		}
		
		//System.out.println("����ǰ��" + Arrays.toString(arr));
		
		
		long begin = System.currentTimeMillis();//��ȡ����֮ǰϵͳ��ǰ��ʱ�䣬long
		
		/*
		 * ð������n���������Ŷӣ��������С��ǰ�����ѭ��n-1���ڲ�ѭ��n-1-i
		 * */
		for (int i = 0; i < arr.length - 1; i++) {
			//��Ϊð������ÿ�ν�����ֵ�ŵ��������������һ������ʱ���Ϳ����ų�����֪�������
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {//ǰһ��ֵ�Ⱥ�һ��ֵ���򽻻�λ��
					/*int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;*/
					arr[j + 1] = arr[j + 1] ^ arr[j];
					arr[j] = arr[j] ^ arr[j + 1];
					arr[j + 1] =  arr[j + 1] ^ arr[j];
				}
			}
		}
		//Arrays.sort(arr);
		
		long end = System.currentTimeMillis();//��ȡ���������ϵͳ��ǰ��ʱ�䣬long
		System.out.println("��ʱ��" + (end - begin));
		//System.out.println("�����" + Arrays.toString(arr));
	}
}
