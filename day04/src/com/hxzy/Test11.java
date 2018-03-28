package com.hxzy;

public class Test11 {

	/*
	 * 使用java随机生成1000次 范围在 -50000~50000的正整数，然统计每个随机数字出现的次数，要求时间在10秒以内完成
	 * */
	public static void main(String[] args) {
		int[] arr = new int[100000];//动态数组
		
		long begin = System.currentTimeMillis();
		
		//为数组赋值
		for (int i = 0; i < 1000; i++) {
			int ran = (int)(Math.random() * 100000);
			arr[ran] = arr[ran] + 1;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				System.out.print("数组" + (i - 50000) + "出现了" + arr[i] + "次\t");
			}
		}
		
		System.out.println("最大的5个数字为：");
		int count = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] != 0) {
				System.out.println(i - 50000);
				count++;
				if (count == 5) {
					break;
				}
			}
		}
		
		long end = System.currentTimeMillis();
		long time = end - begin;
		System.out.println("\n总共耗时:" + time);
	}

}
