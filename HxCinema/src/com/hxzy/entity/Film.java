package com.hxzy.entity;

import java.util.Date;

/**
 * ��Ӱ
 * ������������ĳ����Ӱ��Ϣ����
 * Film wuWenXiDong = new Film();
 * Film yongZheGame = new Film();
 * @author Administrator
 *
 */
public class Film {
	/*
	 * ����
		����
		���еص�
		ʱ��
		��ӳʱ��
		������
*/
	private int fNo;//��Ӱ���
	private String name;
	private String type;
	private String location;
	private int time;//ʱ������λ���ӣ�65����
	private Date date;//����ʱ�� ����ʽ��2018-01-18
	private String info;//������
	
	public int getfNo() {
		return fNo;
	}
	public void setfNo(int fNo) {
		this.fNo = fNo;
	}
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	
	
	
}
