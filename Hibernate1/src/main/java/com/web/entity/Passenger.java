package com.web.entity;

import java.io.Serializable;
import java.util.Set;

public class Passenger implements Serializable {

	private Integer pid;
	private String pName;
	private Set<Car> carSet;//多对多 双向
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public Set<Car> getCarSet() {
		return carSet;
	}
	public void setCarSet(Set<Car> carSet) {
		this.carSet = carSet;
	}
	
}
