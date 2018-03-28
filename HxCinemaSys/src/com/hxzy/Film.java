package com.hxzy;

/**
 * 电影
 * 用于描述具体某部电影信息的类
 * Film wuWenXiDong = new Film();
 * Film yongZheGame = new Film();
 * @author Administrator
 *
 */
public class Film {
	/*
	 * 名称
		类型
		发行地点
		时长
		上映时间
		剧情简介
*/
	private String name;
	private String type;
	private String location;
	private int time;//时长，单位分钟，65分钟
	private String date;//上映时间 ，格式：2018-01-18
	private String info;//剧情简介
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	
	
	
}
