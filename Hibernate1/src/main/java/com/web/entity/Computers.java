package com.web.entity;

import java.io.Serializable;
import java.util.Date;


public class Computers implements Serializable {

	private Integer cid;
	private String cname;
	private Integer csize;
	private Date cdate;
	
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
	public Integer getCsize() {
		return csize;
	}
	public void setCsize(Integer csize) {
		this.csize = csize;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	public Computers() {
		super();
	}
	public Computers(String cname, Integer csize, Date cdate) {
		super();
		this.cname = cname;
		this.csize = csize;
		this.cdate = cdate;
	}
	
	
}
