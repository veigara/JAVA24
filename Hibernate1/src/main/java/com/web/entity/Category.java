package com.web.entity;

import java.io.Serializable;

public class Category implements Serializable {

	private Integer cid;
	private String cname;
	private Bread bread;//多对一      多个类别对应一个面包
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Bread getBread() {
		return bread;
	}
	public void setBread(Bread bread) {
		this.bread = bread;
	}
	
	
}
