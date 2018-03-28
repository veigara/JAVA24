package com.hxzy;

import java.util.Arrays;

public class Dichotomy_2 {

	public static void main(String[] args) {
		int[] arr = new int[100000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr.length - 1 - i;
		}
		
		Arrays.sort(arr);//排序，升序
		
		//假设在0 - 99999范围中查找99876，统计循环多少次
		
		int num = 49999;
		int count = 0;
		
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int middle = (start + end) / 2;//中间数的下标
			count++;
			if (arr[middle] > num) {
				end = middle - 1; //在中间数之前的半部分查找
			} else if (arr[middle] < num) {
				start = middle + 1;//中间数之后的半部分查找
			} else {
				System.out.println("找到了，这个数的下表为：" + middle + ",总共循环了" + count + "次");
				break;
			}
		}
		
		
	}

}
