package com.hxzy.object;

public class Item03 {
	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "abc";
		System.out.println(str1 == str2);//true
		
		str2 = "bca";
		System.out.println(str1 == str2);
		
		String str3 = new String("abc");//new 代表在堆中开辟了一个新的内存空间，有对应的内存地址
		System.out.println(str1.intern() == str3.intern());
		
		String str4 = "def";
		String str5 = "abcdef";
		String str6 = str1 + str4;
		System.out.println(str6 == str5);
		System.out.println(str6.intern() == str5.intern());
	}
}
