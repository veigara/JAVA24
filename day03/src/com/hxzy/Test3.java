package com.hxzy;

import java.util.Scanner;

public class Test3 {

	/*
	 * �ж�һ���������Ƿ��ǻ�����
	 * */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("������һ������");
		int num = input.nextInt();
		/*
			1.�����û���������֣����Ǵ�ʱ�ǲ�֪���û�����������м�λ
		 		һ�����͵����֣������Գ�10��ֱ�����Ϊ0����¼�������ô���Ϊ������ֵĳ���
		 * */
		int length = 0;
		int temp = num;
		while (temp > 0) {
			temp /= 10;
			length++;
		}
		
		/*
		 * 2.���ݳ���ѭ����
		 * 		���磺num=123456
		 * 			1��6��ȣ�2��5���
		 * 			�ֱ���1,2��3,4,5,6
		 * 				1:123456 / 100000 % 10
		 * 				2:123456 / 10000 % 10
		 * 				3:123456 / 1000 % 10
		 * 				4:123456 / 100 % 10
		 * 				5:123456 / 10 % 10
		 * 				6:123456 % 10
		 * 
		 * public static double pow(double a,double b)
		 * 	Math.pow(10,5)  ==>  100000.00
		 * */
		boolean flag = true;//Ĭ���ǻ�����
		for (int i = 0; i < length / 2; i++) {
			//��λ
			int high = num / (int)Math.pow(10, length - 1 - i) % 10;
			
			//��λ
			int low = num / (int)Math.pow(10, i) % 10;
			System.out.println("high��" + high + "��low��" + low);

			/*if (high != low) {
				flag = false;//���ǣ�ֻҪhigh��low����ͬ��˵�����ǻ�����
				break;
			}*/
			
			if ((high ^ low) == 0) {
				flag = false;//���ǣ�ֻҪhigh��low����ͬ��˵�����ǻ�����
				break;
			}
		}
		
		if (flag) {
			System.out.println("������");
		} else {
			System.out.println("���ǻ�����");
		}
	}

}
