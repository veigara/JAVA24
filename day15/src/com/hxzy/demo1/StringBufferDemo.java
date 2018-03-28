package com.hxzy.demo1;

public class StringBufferDemo {

	public static void main(String[] args) {
		/*
		 * StringBuffer sb = new StringBuffer();
		 * StringBuffer sb = new StringBuffer(50);
		 * StringBuffer sb = new StringBuffer("明宇");
		 * */
		
		/*StringBuffer sb = new StringBuffer("重庆华信智原");
		sb.append("\n《关于2017寒假放假的通知》");
		sb.append("\t一、放假时间");
		sb.append("\t\t2018年2月10日日-2018年2月22日");
		
		System.out.println(sb.toString());*/
		
		/*链式编程*/
		StringBuffer sb = new StringBuffer("重庆华信智原");
		sb.append("\n《关于2017寒假放假的通知》")
			.append("\t一、放假时间")
			.append("\t\t2018年2月10日日-2018年2月22日");
		sb.insert(5, "特此同此通知");//向指定的下标处插入字符串
		sb.reverse();//反转字符串
		/*
		 * sb.delete(int startIndex,int endIndex);  删除指定区域的字符串
		 * */
		System.out.println(sb.toString());
		
		
	}

}
