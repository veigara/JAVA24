package com.hxzy4;

public class Recursion {

	public void a() {
		System.out.println("a");
	}
	
	/**
	 * �ݹ�
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
	
	//��������Ĵ�����а��������Լ��ķ���
	public static void main(String[] args) {
		Recursion r = new Recursion();
		r.b(1);
	}
}
