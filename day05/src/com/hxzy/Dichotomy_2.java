package com.hxzy;

import java.util.Arrays;

public class Dichotomy_2 {

	public static void main(String[] args) {
		int[] arr = new int[100000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr.length - 1 - i;
		}
		
		Arrays.sort(arr);//��������
		
		//������0 - 99999��Χ�в���99876��ͳ��ѭ�����ٴ�
		
		int num = 49999;
		int count = 0;
		
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int middle = (start + end) / 2;//�м������±�
			count++;
			if (arr[middle] > num) {
				end = middle - 1; //���м���֮ǰ�İ벿�ֲ���
			} else if (arr[middle] < num) {
				start = middle + 1;//�м���֮��İ벿�ֲ���
			} else {
				System.out.println("�ҵ��ˣ���������±�Ϊ��" + middle + ",�ܹ�ѭ����" + count + "��");
				break;
			}
		}
		
		
	}

}
