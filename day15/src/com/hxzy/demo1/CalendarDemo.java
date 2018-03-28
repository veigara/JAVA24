package com.hxzy.demo1;

import java.util.Calendar;
import java.util.Date;

public class CalendarDemo {

	public static void main(String[] args) {
		Date date = new Date();
		int year = date.getYear();
		date.getMonth();
		date.getDate();
		System.out.println(year);
		
		/*
		 * 为了解决Date对象中的过时方法，Calendar类提供了替换方案
		 * Calendar.YEAR  获取年份
		 * Calendar.MONTH 获取月份
		 * Calendar.DATE  获取日期
		 * Calendar.DAY   获取星期几
		 * Calendar.WEEK_OF_MONTH 获取日期是这个月的第几周
		 * Calendar.WEEK_OF_YEAR 获取日期是该年的第几周
		 * Calendar.SECOND 获取秒
		 * Calendar.MINUTE 获取分钟
		 * Calendar.HOUR 获取小时，12小时制
		 * Calendar.HOUR_OF_DAY 获取24小时制的小时
		 * Calendar.AM_PM   AM上午，PM下午
		 * 
		 * */
		Calendar c = Calendar.getInstance(); //默认当前时间
		
		Date date2 = new Date(1496160000000L);//设置指定时间
		c.setTime(date2);
		
		System.out.println("年份：" + c.get(Calendar.YEAR));
		System.out.println("月份：" + (c.get(Calendar.MONTH) + 1));
		System.out.println("日期：" + c.get(Calendar.DATE));
	}
}
