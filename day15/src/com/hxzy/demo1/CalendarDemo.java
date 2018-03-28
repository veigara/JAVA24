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
		 * Ϊ�˽��Date�����еĹ�ʱ������Calendar���ṩ���滻����
		 * Calendar.YEAR  ��ȡ���
		 * Calendar.MONTH ��ȡ�·�
		 * Calendar.DATE  ��ȡ����
		 * Calendar.DAY   ��ȡ���ڼ�
		 * Calendar.WEEK_OF_MONTH ��ȡ����������µĵڼ���
		 * Calendar.WEEK_OF_YEAR ��ȡ�����Ǹ���ĵڼ���
		 * Calendar.SECOND ��ȡ��
		 * Calendar.MINUTE ��ȡ����
		 * Calendar.HOUR ��ȡСʱ��12Сʱ��
		 * Calendar.HOUR_OF_DAY ��ȡ24Сʱ�Ƶ�Сʱ
		 * Calendar.AM_PM   AM���磬PM����
		 * 
		 * */
		Calendar c = Calendar.getInstance(); //Ĭ�ϵ�ǰʱ��
		
		Date date2 = new Date(1496160000000L);//����ָ��ʱ��
		c.setTime(date2);
		
		System.out.println("��ݣ�" + c.get(Calendar.YEAR));
		System.out.println("�·ݣ�" + (c.get(Calendar.MONTH) + 1));
		System.out.println("���ڣ�" + c.get(Calendar.DATE));
	}
}
