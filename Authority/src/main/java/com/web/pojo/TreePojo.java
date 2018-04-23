package com.web.pojo;

import java.util.List;

public class TreePojo {

	private Integer id;
	private Integer pId;
	private String name;
	private String url;
	private String icon;
	private List<TreePojo> children;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public List<TreePojo> getChildren() {
		return children;
	}
	public void setChildren(List<TreePojo> children) {
		this.children = children;
	}
	
	
	
}
