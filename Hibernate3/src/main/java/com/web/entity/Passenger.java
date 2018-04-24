package com.web.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity //实体类
@Table(name="t_passenger") //表
public class Passenger implements Serializable {

	private Integer pid;
	private String pName;
	private Set<Car> carSet;//多对多 双向
	
	@Id //主键
	@GeneratedValue(strategy=GenerationType.IDENTITY) //生成策略
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
	
	@ManyToMany //多对多
	@JoinTable(name="t_car_passenger",joinColumns={@JoinColumn(name="passengerId")},
		inverseJoinColumns={@JoinColumn(name="carId")}) //中间表
	public Set<Car> getCarSet() {
		return carSet;
	}
	public void setCarSet(Set<Car> carSet) {
		this.carSet = carSet;
	}
	
}
