package com.hxzy;

import java.util.Arrays;

public class InsertSort {

	public static void main(String[] args) {
		
		int[] arr = new int[500000];
		/*for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10);
		}*/
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr.length - 1 - i;
		}
		System.out.println("初始化数组完成，开始排序");
		long begin = System.currentTimeMillis();
	    //假定第一个元素被放到了正确的位置上
	    //这样，仅需遍历1 - n-1
	    for (int i = 1; i < arr.length; i++)
	    {
	        int j = i; //j是用于比较的元素的下标
	        int target = arr[i];
	        
	        //内层while循环就是用来从右往左比较的过程
	        while (j > 0 && target < arr[j - 1])
	        {
	            arr[j] = arr[j - 1];
	            j--;
	        }
	 
	        if (i != j) {
	        	arr[j] = target;
			}
	    }
	    long end = System.currentTimeMillis();
	    
	    long time = end - begin;
	    System.out.println("使用插入排序排列10万个数字耗时：" + time);
	}

}
