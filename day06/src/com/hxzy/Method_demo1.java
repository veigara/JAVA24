package com.hxzy;

public class Method_demo1 {

	/**
	 * 无参数，无返回值的方法
	 * void:空
	 * 调用了a1的方法以后，不会获得任何东西
	 */
	public void a1() {
		/*如何让void的方法执行一半就结束*/
		if (true) {
			return;
		}
	}
	
	/**
	 * 有参数，无返回值的方法
	 * @param num 一个数字
	 */
	public void a2(int num) {
		
	}
	/**
	 * 有返回值，无参数的方法
	 * 代表，调用了a3方法后，可以得到一个int类型的值
	 * @return 得到一个整数
	 */
	public int a3() {
		
		return 0;
	}
	
	public String a4(int num1,int num2) {
		if (num1 > num2) {
			return "hello java oop";
		}
		return null;
	}
	
	/**
	 * 有参数，有返回值的方法
	 * @param num1
	 * @param str1
	 * @param c
	 * @return
	 */
	public int[] a5(int num1,String str1,char c) {
		int[] arr = {1,2,3};
		return arr;
	}
}
