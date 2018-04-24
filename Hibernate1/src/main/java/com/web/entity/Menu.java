package com.web.entity;

import java.io.Serializable;

public class Menu implements Serializable {

	private Integer mId;
	private String mName;
	public Integer getmId() {
		return mId;
	}
	public void setmId(Integer mId) {
		this.mId = mId;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	
}
