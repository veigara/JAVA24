package com.hxzy;

public class Array_1 {

	public static void main(String[] args) {
		int[] arr1;//声明了一个int类型的数组
		int arr2[];
		
		//动态初始化数组,由系统为数组中的每个元素指定默认值
		/*
		 * byte   0
		 * short  0
		 * int    0
		 * long   0
		 * flaot  0.0f
		 * double 0.0
		 * char   \u0000
		 * String null
		 * 
		 * */
		arr1 = new int[5];
		
		System.out.println(arr1[0]);
		
		int[] arr3 = new int[5];//声明数组，并分配空间
		
		//静态初始化数组,数组的长度由初始化的数字的个数决定
		int[] arr4 = {98,5,67,35};
		int[] arr5 = new int[] {98,5,67,35};
		
		System.out.println(arr5);
	}

}
