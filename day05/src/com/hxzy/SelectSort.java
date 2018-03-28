package com.hxzy;

public class SelectSort {

	public static void main(String[] args) {
		int[] arr = new int[100000];//动态初始化数组
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 1000);
		}
		
		long begin = System.currentTimeMillis();//获取排序之前系统当前的时间，long
		
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;//记录最小的值的下标,不指定0的原因：每次比较以后，选择排序都是把最小的值放到数组的最前面
			
			//内层循环执行完毕之后，就能够确定出来最小值的下标
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			
			//如果经过了内层循环的比较，最小值的下标不再等于初始的i，因此，可以知道minIndex此时为最小值的下标
			if(minIndex != i){
				arr[minIndex] = arr[i] ^ arr[minIndex];
				arr[i] = arr[i] ^ arr[minIndex];
				arr[minIndex] =  arr[i] ^ arr[minIndex];
			}
		}
		
		long end = System.currentTimeMillis();//获取排序结束后系统当前的时间，long
		System.out.println("耗时：" + (end - begin));
	}

}
