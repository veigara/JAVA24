package com.hxzy2;

/**
 * ������
 * ����������������ĳ����Ӱ���ų���Ϣ
 * @author Administrator
 *
 */
public class FilmItem {
	private String time;//�ų�ʱ��    9:45  10:45  12:25  
	private String language;
	private String hourse;//��ӳ����11������ĵ����
	private double price; //��ͬʱ���ļ۸�һ��
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getHourse() {
		return hourse;
	}
	public void setHourse(String hourse) {
		this.hourse = hourse;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
