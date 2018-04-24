package com.web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //实体类
@Table(name="t_classes") //表
public class Classes implements Serializable {

	private Integer cid;
	private String cname;
	
	@Id //主键
	@GeneratedValue(strategy=GenerationType.IDENTITY) //生成策略
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
	@Column(length=30,nullable=false)
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
}
