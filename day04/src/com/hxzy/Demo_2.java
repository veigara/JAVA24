package com.hxzy;

import java.util.Scanner;

public class Demo_2 {
	public static void main(String[] args) {
		int[] arr = {8,4,2,1,23,344,12};
		
		Scanner input = new Scanner(System.in);
		System.out.println("������һ����");
		int num = input.nextInt();
		int sum = 0;
		
		boolean flag = false;//���ǣ�����û�������
		/*���������ÿ��Ԫ�ص�ֵ��Ҳ��Ϊ��������*/
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			
			if ((num ^ arr[i]) == 0) {
				flag = true;//�ҵ������
			}
			
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
		System.out.println("arr����������Ԫ�صĺͣ�" + sum);
		
		if (flag) {
			System.out.println("�ҵ���");
		}else {
			System.out.println("û�������");
		}
		
	}
}
