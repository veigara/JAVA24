package com.hxzy;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		//创建一个固定长度数组，通过随机数为数组赋值
		int[] arr = new int[100000];//动态初始化数组
		
		//生成随机数的两种方式：1
		/*Random ran = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = ran.nextInt(1000) + 1; //随机生成1-1000的随机数
		}*/
		//2.Math.random()   double   0-1小数
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 1000);
		}
		
		//System.out.println("排序前：" + Arrays.toString(arr));
		
		
		long begin = System.currentTimeMillis();//获取排序之前系统当前的时间，long
		
		/*
		 * 冒泡排序：n个数字来排队，两两相比小靠前，外层循环n-1，内层循环n-1-i
		 * */
		for (int i = 0; i < arr.length - 1; i++) {
			//因为冒泡排序每次将最大的值放到数组的最后，因此下一次排序时，就可以排除掉已知的最大数
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {//前一个值比后一个值大，则交换位置
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
		
		long end = System.currentTimeMillis();//获取排序结束后系统当前的时间，long
		System.out.println("耗时：" + (end - begin));
		//System.out.println("排序后：" + Arrays.toString(arr));
	}
}
