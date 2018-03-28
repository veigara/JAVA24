package com.hxzy;

import java.util.Arrays;

/**
 * 二分法，折半算法
 * 
 * @author Administrator
 *
 */
public class Dichotomy {
	public static void main(String[] args) {
		/*
		 * 查看新华字典 饕餮
		 * 
		 * 假设有一个100万的长度的数组，要求在这个数组中查找859998个数字 1.使用二分法的前提，必须保证这个数字是有序 2.找中间数
		 * 用这个数字859998和50万比较 应该在（50+100）/2 已75万为中间数
		 * 
		 * (75 + 100 ) / 2 中间数为87万 用87万和859998比较
		 * 
		 * (75 + 87) / 2 中间数81万 81和859998比较 (81 + 87) / 84 (84 + 87) / 2 85.5 (85.5+87)
		 * / 2 86.25 (86.25 + 85.5) / 2
		 */

		int[] arr = { 998, 765, 888, 456, 321, 1, 59, 65, 159, 753 };

		Arrays.sort(arr);// 使用Arrays类的sort方法进行排序
		//System.out.println(Arrays.toString(arr));
		// 假设在这个有序的数组中查找321这个数
		int num = 888;
		
		int start = 0;//开始位置
		int end = arr.length - 1; //结束为止
		while (start <= end) {
			int middle = (start + end) / 2; //确定中间数的下标
			if (num < arr[middle]) { //如果查找的num比中间数要小，因此确定num在中间数之前（前半部分）
				end = middle - 1;
			} else if (num > arr[middle]) {
				start = middle + 1;
			} else {
				System.out.println(middle);
				break;
			}
		}
	}
}
