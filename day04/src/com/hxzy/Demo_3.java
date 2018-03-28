package com.hxzy;

/**
 * 数组中求最大值
 * @author Administrator
 *
 */
public class Demo_3 {

	public static void main(String[] args) {
		int[] arr = {8,4,2,1,23,344,12};
		//声明一个变量，默认认为该数值最大
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		System.out.println("最大值" + max);
	}
}
