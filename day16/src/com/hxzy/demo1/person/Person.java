package com.hxzy.demo1.person;

import java.util.List;

public class Person {

	/*信息，信息有可能有多条*/
	private List<? extends Info> list;

	public List<? extends Info> getList() {
		return list;
	}

	public void setList(List<? extends Info> list) {
		this.list = list;
	}
	
	
}
