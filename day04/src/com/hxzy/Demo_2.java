package com.hxzy;

import java.util.Scanner;

public class Demo_2 {
	public static void main(String[] args) {
		int[] arr = {8,4,2,1,23,344,12};
		
		Scanner input = new Scanner(System.in);
		System.out.println("请输入一个数");
		int num = input.nextInt();
		int sum = 0;
		
		boolean flag = false;//打标记，代表没有这个数
		/*输出数字中每个元素的值，也称为遍历数组*/
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			
			if ((num ^ arr[i]) == 0) {
				flag = true;//找到这个数
			}
			
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
		System.out.println("arr数组中所有元素的和：" + sum);
		
		if (flag) {
			System.out.println("找到了");
		}else {
			System.out.println("没有这个数");
		}
		
	}
}
