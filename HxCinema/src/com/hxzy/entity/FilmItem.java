package com.hxzy.entity;

import java.util.Date;

/**
 * ������
 * ����������������ĳ����Ӱ���ų���Ϣ
 * @author Administrator
 *
 */
public class FilmItem {
	private int itemNo;
	private CinemaFilmRelation cfr;
	private Date time;//�ų�ʱ��    9:45  10:45  12:25  
	private String language;
	private String hourse;//��ӳ����11������ĵ����
	private double price; //��ͬʱ���ļ۸�һ��
	
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public CinemaFilmRelation getCfr() {
		return cfr;
	}
	public void setCfr(CinemaFilmRelation cfr) {
		this.cfr = cfr;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
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
