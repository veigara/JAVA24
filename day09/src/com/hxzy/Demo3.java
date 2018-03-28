package com.hxzy;

public class Demo3 {

	/**
	 * 这是一个有参方法，参数列表为一个int类型的数组
	 * @param arr
	 */
	public void test(int[] arr) {
		
	}
	
	private void test1() {
		int[] arr = {99,88,77,66};
		test(arr);
		
		/*
		 * 可变长度参数列表的方法的调用
		 * 
		 * */
		test2(arr); //传递int类型的数组
		test2();  //不传递任何参数
		test2(2,3,5,6,9);//传递任意个数的int类型的参数
		
		//test2("");
		//test2("",1,2,3,4,5);
	}
	
	/*
	 * 声明可变长度的参数列表的方法时，可变长度参数必须放到参数列表的末尾
	 * test(String str,int...params)
	 * test(int num1,int...params)
	 * 
	 * 在使用可变长度参数列表时，就把它当成一个普通数组运用就ok了，但是需要判断这个数组是否为空
	 * */
	public void test2(int...a) {
		if (a != null) {
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i] + "\t");
			}
			System.out.println();
		}
	}
	
	public void test2(String a,int...params) {}
	
	public static void main(String[] args) {
		Demo3 demo3 = new Demo3();
		demo3.test1();
	}
}
