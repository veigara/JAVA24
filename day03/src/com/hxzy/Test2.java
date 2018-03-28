package com.hxzy;

public class Test2 {

	public static void main(String[] args) {
		/*
		    *
		   * *
		  * * *
		 * * * *
		* * * * *
		 * * * *
		  * * *
		   * *
		    *
		 上半部分
		 	外层循环负责行数，内层需要两个循环
		 	一个循环负责打印空格
		 	一个循环负责打印*
		 	
		下半部分
			外层循环负责行数，内层需要两个循环
			一个循环负责打印空格
		 	一个循环负责打印*
		 */
		
		/*上半部分*/
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4 - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i + 1; j++) {
				System.out.print("* ");
			}
			System.out.println();//外层循环每次需要换行
		}
		
		/*下半部分*/
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 4 - i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

}
