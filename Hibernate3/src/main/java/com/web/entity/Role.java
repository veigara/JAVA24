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


@Entity
@Table(name="t_role")
public class Role implements Serializable {

	private Integer rid;
	private String rname;
	private Set<Menu> menuSet;// 多对多  
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	
	@ManyToMany //多对多
	@JoinTable(name="t_menu_role",joinColumns={@JoinColumn(name="roleId")},
	    inverseJoinColumns={@JoinColumn(name="menuId")}) //中间表
	public Set<Menu> getMenuSet() {
		return menuSet;
	}
	public void setMenuSet(Set<Menu> menuSet) {
		this.menuSet = menuSet;
	}
	
	
	
}
