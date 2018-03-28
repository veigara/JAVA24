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
		
		/* replaceAll(正则表达式，替换为什么)  
		  第一个参数："\\s{1,}" 正则表达式，用于匹配1个或多个空格
		
		 第二个参数：将正则表达式匹配的空字符替换为空
		*/
		str = str.replaceAll("\\s+", "");//在java中使用正则表达式来替换匹配的空格
		System.out.println(str);
	}

}
