package com.web.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;


@Entity //实体类
@Table(name="t_car") //表
public class Car implements Serializable {

	private Integer cid;
	private String cname;
	private Set<Passenger> passenSet;//多对多 双向
	
	@Id //主键
	@GeneratedValue(strategy=GenerationType.IDENTITY) //生成策略
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
	
	@ManyToMany(mappedBy="carSet") //mappedBy： 当前实体类(Car)在关联的对象(Passenger)中的属性名称
	public Set<Passenger> getPassenSet() {
		return passenSet;
	}
	public void setPassenSet(Set<Passenger> passenSet) {
		this.passenSet = passenSet;
	}
	
}
