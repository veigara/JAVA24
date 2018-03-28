package com.hxzy.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 成绩表对应的实体类
 * @author Administrator
 *
 */
public class Result implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Student stu;
	private Subject subject;
	private Date examDate;
	private Integer stuResult;
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Date getExamDate() {
		return examDate;
	}
	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}
	public Integer getStuResult() {
		return stuResult;
	}
	public void setStuResult(Integer stuResult) {
		this.stuResult = stuResult;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((examDate == null) ? 0 : examDate.hashCode());
		result = prime * result + ((stu == null) ? 0 : stu.hashCode());
		result = prime * result + ((stuResult == null) ? 0 : stuResult.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
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
		Result other = (Result) obj;
		if (examDate == null) {
			if (other.examDate != null)
				return false;
		} else if (!examDate.equals(other.examDate))
			return false;
		if (stu == null) {
			if (other.stu != null)
				return false;
		} else if (!stu.equals(other.stu))
			return false;
		if (stuResult == null) {
			if (other.stuResult != null)
				return false;
		} else if (!stuResult.equals(other.stuResult))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		return true;
	}
	public Result(Student stu, Subject subject, Date examDate, Integer stuResult) {
		super();
		this.stu = stu;
		this.subject = subject;
		this.examDate = examDate;
		this.stuResult = stuResult;
	}
	public Result() {
		super();
	}
	
}
