package com.web.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_teacher")
public class Teacher implements Serializable {

	private Integer tid;
	private String tname;
	private Set<Classes> clist;//一对多   一个教师对应多个班级
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	
	@OneToMany  //一对多
	@JoinColumn(name="teacherId") //外键字段
	public Set<Classes> getClist() {
		return clist;
	}
	public void setClist(Set<Classes> clist) {
		this.clist = clist;
	}
	
}
