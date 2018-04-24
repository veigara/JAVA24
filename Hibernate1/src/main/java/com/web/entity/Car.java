package com.web.entity;

import java.io.Serializable;
import java.util.Set;

public class Car implements Serializable {

	private Integer cid;
	private String cname;
	private Set<Passenger> passenSet;//多对多 双向
	
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
	public Set<Passenger> getPassenSet() {
		return passenSet;
	}
	public void setPassenSet(Set<Passenger> passenSet) {
		this.passenSet = passenSet;
	}
	
}
