package com.hxzy.entity;

import java.io.Serializable;

/**
 * 科目表的实体类
 * @author Administrator
 *
 */
public class Subject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int subjectNo;
	private String subjectName;
	public int getSubjectNo() {
		return subjectNo;
	}
	public void setSubjectNo(int subjectNo) {
		this.subjectNo = subjectNo;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((subjectName == null) ? 0 : subjectName.hashCode());
		result = prime * result + subjectNo;
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
		Subject other = (Subject) obj;
		if (subjectName == null) {
			if (other.subjectName != null)
				return false;
		} else if (!subjectName.equals(other.subjectName))
			return false;
		if (subjectNo != other.subjectNo)
			return false;
		return true;
	}
	public Subject(int subjectNo, String subjectName) {
		super();
		this.subjectNo = subjectNo;
		this.subjectName = subjectName;
	}
	public Subject() {
		super();
	}
	
	
}
