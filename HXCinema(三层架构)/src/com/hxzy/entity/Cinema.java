package com.hxzy.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * ��ӰԺ����
 * ����������������ĳ����ӰԺ
 * Cinema wanDa = new Cinema();
 * Cinema UME = new Cinema();
 * @author Administrator
 *
 */
public class Cinema {
	private int cNo;	//ӰԺ���
	private String name;//ӰԺ����
	
	public int getcNo() {
		return cNo;
	}
	public void setcNo(int cNo) {
		this.cNo = cNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cNo;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cinema other = (Cinema) obj;
		if (cNo != other.cNo)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
