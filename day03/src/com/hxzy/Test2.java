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
		 �ϰ벿��
		 	���ѭ�������������ڲ���Ҫ����ѭ��
		 	һ��ѭ�������ӡ�ո�
		 	һ��ѭ�������ӡ*
		 	
		�°벿��
			���ѭ�������������ڲ���Ҫ����ѭ��
			һ��ѭ�������ӡ�ո�
		 	һ��ѭ�������ӡ*
		 */
		
		/*�ϰ벿��*/
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4 - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i + 1; j++) {
				System.out.print("* ");
			}
			System.out.println();//���ѭ��ÿ����Ҫ����
		}
		
		/*�°벿��*/
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
