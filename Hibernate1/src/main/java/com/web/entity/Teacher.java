package com.web.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class Teacher implements Serializable {

	private Integer tid;
	private String tname;
	private Set<Classes> clist;//一对多   一个教师对应多个班级
	
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Set<Classes> getClist() {
		return clist;
	}
	public void setClist(Set<Classes> clist) {
		this.clist = clist;
	}
	
}
