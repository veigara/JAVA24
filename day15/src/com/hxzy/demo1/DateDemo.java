package com.hxzy.demo1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {

	public static void main(String[] args) {
		Date date1 = new Date();//当前时间
		//java.sql.Date date2 = new java.sql.Date(0);
		System.out.println(date1);
		System.out.println(date1.getTime());
		Date date2 = new Date(1517367332007L);
		System.out.println(date2.toString());
		System.out.println();
		format(date2);
		System.out.println();
		parse();
	}

	/*将日期对象格式化成为字符串*/
	private static void format(Date date) {
		/*
		 * yyyy-MM-dd hh:mm:ss
		 * yyyy-MM-dd
		 * yyyy/MM/dd
		 * yyyy年MM月dd日
		 * MM-dd
		 * */
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String format = sdf.format(date);//将日期按照yyyy-MM-dd hh:mm:ss格式化成为字符串
		System.out.println(format);
	}
	
	private static void parse() {
		String dateStr = "05-31-2017";
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		try {
			Date parse = sdf.parse(dateStr);
			System.out.println(parse.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
}
