package com.web.entity;

import java.io.Serializable;
import java.util.Set;

public class Role implements Serializable {

	private Integer rid;
	private String rname;
	private Set<Menu> menuSet;// 多对多  
	
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public Set<Menu> getMenuSet() {
		return menuSet;
	}
	public void setMenuSet(Set<Menu> menuSet) {
		this.menuSet = menuSet;
	}
	
	
	
}
