package com.hxzy.entity;

import java.util.Date;

/**
 * 场次类
 * 该类用于描述具体某部电影的排场信息
 * @author Administrator
 *
 */
public class FilmItem {
	private int itemNo;
	private CinemaFilmRelation cfr;
	private Date time;//排场时间    9:45  10:45  12:25  
	private String language;
	private String hourse;//放映厅，11号厅，牡丹厅
	private double price; //不同时间点的价格不一样
	
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
