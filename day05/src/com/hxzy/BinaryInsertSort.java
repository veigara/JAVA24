package com.hxzy;

import java.util.Arrays;

public class BinaryInsertSort {
	/**
	 * �۰��������
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = new int[10000000];
		for (int i = 0; i < arr.length; i++) {
			//arr[i] = arr.length - 1 - i;
			arr[i] = (int)(Math.random() * 10000000);
		}
		
		System.out.println("�����ʼ����ɣ�׼����ʼ����");
		long begin = System.currentTimeMillis();
		
		int arrayLength = arr.length;
		for (int i = 1; i < arrayLength; i++) {
			int target = arr[i];
			
			int start = 0;  //start
			int end = i - 1; //end
			while (start <= end) {
				int mid = (start + end) / 2;
				if (target > arr[mid]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
			int j = i;
			while (j > start) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[start] = target;
		}
		
		long end = System.currentTimeMillis();
		long time = end - begin;
		System.out.println("ʹ���۰������������10������ֺ�ʱ��" + time);
	}

}
