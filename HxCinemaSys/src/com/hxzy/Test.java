package com.hxzy;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		//test1();
		
		test2();
	}

	private static void test1() {
		int a = 1;
		int b = 1;
		for (int i = 0; i < 20; i++) {
			a = a + b;
			b = a - b;
			System.out.print(a + "/" + b + " ");
		}
	}
	
	private static void test2() {
		String str="s   tr  in     g";
		/*String str2 = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ') {
				str2 += str.charAt(i);
			}
		}
		System.out.println(str2);*/
		
		/* replaceAll(������ʽ���滻Ϊʲô)  
		  ��һ��������"\\s{1,}" ������ʽ������ƥ��1�������ո�
		
		 �ڶ�����������������ʽƥ��Ŀ��ַ��滻Ϊ��
		*/
		str = str.replaceAll("\\s+", "");//��java��ʹ��������ʽ���滻ƥ��Ŀո�
		System.out.println(str);
	}

}
