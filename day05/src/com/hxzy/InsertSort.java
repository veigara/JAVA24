package com.hxzy;

import java.util.Arrays;

public class InsertSort {

	public static void main(String[] args) {
		
		int[] arr = new int[500000];
		/*for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10);
		}*/
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr.length - 1 - i;
		}
		System.out.println("��ʼ��������ɣ���ʼ����");
		long begin = System.currentTimeMillis();
	    //�ٶ���һ��Ԫ�ر��ŵ�����ȷ��λ����
	    //�������������1 - n-1
	    for (int i = 1; i < arr.length; i++)
	    {
	        int j = i; //j�����ڱȽϵ�Ԫ�ص��±�
	        int target = arr[i];
	        
	        //�ڲ�whileѭ������������������ȽϵĹ���
	        while (j > 0 && target < arr[j - 1])
	        {
	            arr[j] = arr[j - 1];
	            j--;
	        }
	 
	        if (i != j) {
	        	arr[j] = target;
			}
	    }
	    long end = System.currentTimeMillis();
	    
	    long time = end - begin;
	    System.out.println("ʹ�ò�����������10������ֺ�ʱ��" + time);
	}

}
