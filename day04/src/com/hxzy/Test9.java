package com.hxzy;

public class Test9 {

	public static void main(String[] args) {
		/*
		 * 在一个字符串中找第一个只出现过一次的字符
     如：输入”azbaccdeff”,显示第一个出现过一次的字符是： z

		 * */
		String str = "azbacchdefzfb";
		/*
		 * length()  返回字符串的长度
		 * charAt()  返回指定索引的字符
		 * */
		for (int i = 0; i < str.length(); i++) {
			char item = str.charAt(i);
			boolean flag = true;//打标记
			for (int j = 0; j < str.length(); j++) {
				if (i == j) {
					continue;
				}
				char temp = str.charAt(j);
				if (item == temp) {
					flag = false;
					break;//结束内层循环
				}
			}
			if (flag) {
				System.out.println(item + "是第一出现的一个字符");
				break;
			}
		}
	}

}
