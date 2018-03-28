package com.hxzy;

public class Array_3 {

	public static void main(String[] args) {
		int[][] arr = new int[3][2];
		//System.out.println(arr.length);
		//System.out.println(arr[0].length);
		int[] arr1 = {100,101};
		int[] arr2 = {1,2};
		int[] arr3 = {-10,-9};
		
		/*二维数组赋值*/
		arr[0] = arr1;
		arr[1] = arr2;
		arr[2] = arr3;
		
		/*遍历多维数组时，需要清楚每个元素的类型。*/
		for (int i = 0; i < arr.length; i++) {
			System.out.println("第" + (i + 1) + "个元素的内容：");
			int[] temp = arr[i]; //arr[i] 是一个数组
			for (int j = 0; j < temp.length; j++) {
				System.out.print(temp[j] + "\t");
			}
			System.out.println();
		}
	}

}
