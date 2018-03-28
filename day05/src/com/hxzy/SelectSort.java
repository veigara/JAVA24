package com.hxzy;

public class SelectSort {

	public static void main(String[] args) {
		int[] arr = new int[100000];//��̬��ʼ������
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 1000);
		}
		
		long begin = System.currentTimeMillis();//��ȡ����֮ǰϵͳ��ǰ��ʱ�䣬long
		
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;//��¼��С��ֵ���±�,��ָ��0��ԭ��ÿ�αȽ��Ժ�ѡ�������ǰ���С��ֵ�ŵ��������ǰ��
			
			//�ڲ�ѭ��ִ�����֮�󣬾��ܹ�ȷ��������Сֵ���±�
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			
			//����������ڲ�ѭ���ıȽϣ���Сֵ���±겻�ٵ��ڳ�ʼ��i����ˣ�����֪��minIndex��ʱΪ��Сֵ���±�
			if(minIndex != i){
				arr[minIndex] = arr[i] ^ arr[minIndex];
				arr[i] = arr[i] ^ arr[minIndex];
				arr[minIndex] =  arr[i] ^ arr[minIndex];
			}
		}
		
		long end = System.currentTimeMillis();//��ȡ���������ϵͳ��ǰ��ʱ�䣬long
		System.out.println("��ʱ��" + (end - begin));
	}

}
