package com.hxzy.object;

import java.util.Arrays;

public class StringMethod {

	public static String str = "abcdefghijklmnopqrstuvwxyz     abcdefghijklmnopqrstuvwxyz";
	public static void main(String[] args) {
		//length() 返回字符串字符的个数
		int length = str.length();
		System.out.println("str字符长度为：" + length);
		
		//charAt(下标)  获取指定下标的字符
		char c = str.charAt(str.length() - 1);
		System.out.println(c);
		
		//equals() 字符串等值判断
		System.out.println("equals等值判断：" + str.equals("abcdef"));
		
		//compareTo()  按字典顺序比较字符串，返回int类型的值
		//比比较字符串小，则返回大于0的值，比比较字符串大，则返回小于0的值，相等则返回0
		int result = "abc".compareTo("abe");
		System.out.println(result);
		
		/*
		 * indexOf(String)  获取字符串中第一次出现指定字符串的下标,-1代表没有该字符串
		 * indexOf(int)    int代表asc码     a:97   A:65		-1代表没有该字符串
		 * indexOf(int ch,int fromIndex)   在指定字符串中查询ch的asc码，从fromIndex开始查询。  -1代表没有该字符串
		 * indexOf(String,int fromIndex)   在指定字符串中查询指定的字符串，从fromIndex开始查询。  -1代表没有该字符串
		 * */
		int index = str.indexOf("z");
		System.out.println("z在str中第一次出现的下标：" + index);
		
		//System.out.println(str.indexOf(97));
		//System.out.println(str.indexOf(97, 10));
		
		
		/*
		 * lastIndexOf(String)  返回指定字符串最后一次出现的位置，-1代表没有该字符串
		 * lastIndexOf(String)  获取字符串中最后一次出现指定字符串的下标,-1代表没有该字符串
		 * lastIndexOf(int)    int代表asc码     a:97   A:65		-1代表没有该字符串
		 * lastIndexOf(int ch,int fromIndex)   在指定字符串中查询ch的asc码，从fromIndex开始查询。  -1代表没有该字符串
		 * lastIndexOf(String,int fromIndex)   在指定字符串中查询指定的字符串，从fromIndex开始查询。  -1代表没有该字符串
		 * */
		System.out.println("a最后一次出现的位置：" + str.lastIndexOf("a"));
		
		//startWith(String)  判断字符串是否已指定的字符串开始,boolean
		System.out.println("str已abc开始：" + str.startsWith("abc"));
		
		//endWith(String)  判断字符串已什么结束
		System.out.println("str已z结束：" + str.endsWith("z"));
		
		//regionMatches(boolean ,int,String,int ,int) 判断两个字符串某部分区域的文本是否相同
		/*
		 * 参数1：是否忽略大小写
		 * 参数2：第一个字符串从哪里开始匹配
		 * 参数3：要和哪个字符串比较
		 * 参数4：要从比较的字符串的哪个位置开始
		 * 参数5：匹配多少个字符
		 * */
		String str2 = "EFGHIJ";
		boolean bool = str.regionMatches(true, 4, str2, 0, str2.length()-1);
		System.out.println("str和str2部分相同：" + bool);
		
		/*
		 * subString(int index)  从index开始，截取index之后的所有字符串,返回字符串
		 * subString(int begin,int end) 从begin开始截取，到end结束，返回该区域的字符串
		 * */
		String temp = str.substring(26);
		//System.out.println(temp);
		
		temp = str.substring(0, 26);
		//System.out.println(temp);
		
		//replace(char old,char new)  替换指定的字符,返回替换后的新的字符串,只要符合替换的条件，就替换
		temp = str.replace(' ', '|');
		System.out.println(temp);
		
		//replaceAll() 通常结合正则表达式使用，正则表达式更灵活
		temp = str.replaceAll("\\s+", "|");
		System.out.println(temp);
		
		//trim()  去除字符串两侧的空格,返回新的字符串
		String str3 = "   a b c  ";
		System.out.println("str3去除空格后：" + str3.trim());
		
		//concat(String) 拼接字符串,返回新的字符串,concat就和+拼接的作用是一样的
		String newString = str3.concat("efg");
		System.out.println("concat拼接的字符串：" + newString);
		
		//split(String) 根据指定符号或正则表达式分割字符串成为一个字符串数组
		String param = "1|2|3|4";
		String[] split = param.split("|");
		System.out.println(Arrays.toString(split));
	}
}
