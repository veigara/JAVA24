package com.hxzy;

import java.util.Scanner;

public class Test3 {

	/*
	 * 判断一个正整数是否是回文数
	 * */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入一个整数");
		int num = input.nextInt();
		/*
			1.接收用户输入的数字，但是此时是不知道用户输入的数字有几位
		 		一个整型的数字，不断自除10，直到结果为0，记录次数，该次数为这个数字的长度
		 * */
		int length = 0;
		int temp = num;
		while (temp > 0) {
			temp /= 10;
			length++;
		}
		
		/*
		 * 2.根据长度循环，
		 * 		例如：num=123456
		 * 			1和6相比，2和5相比
		 * 			分别获得1,2，3,4,5,6
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
		boolean flag = true;//默认是回文数
		for (int i = 0; i < length / 2; i++) {
			//高位
			int high = num / (int)Math.pow(10, length - 1 - i) % 10;
			
			//低位
			int low = num / (int)Math.pow(10, i) % 10;
			System.out.println("high：" + high + "，low：" + low);

			/*if (high != low) {
				flag = false;//打标记，只要high和low不相同，说明不是回文数
				break;
			}*/
			
			if ((high ^ low) == 0) {
				flag = false;//打标记，只要high和low不相同，说明不是回文数
				break;
			}
		}
		
		if (flag) {
			System.out.println("回文数");
		} else {
			System.out.println("不是回文数");
		}
	}

}
