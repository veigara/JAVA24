package com.hxzy4;

public class Recursion {

	public void a() {
		System.out.println("a");
	}
	
	/**
	 * 递归
	 */
	public void b(int count) {
		System.out.println("b" + count);
		//a();
		count++;
		if (count == 5) {
			return;
		}
		b(count);
		System.out.println("out b" + count);
	}
	
	//方法本身的代码块中包含调用自己的方法
	public static void main(String[] args) {
		Recursion r = new Recursion();
		r.b(1);
	}
}
