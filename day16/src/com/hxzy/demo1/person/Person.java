package com.hxzy.demo1.person;

import java.util.List;

public class Person {

	/*��Ϣ����Ϣ�п����ж���*/
	private List<? extends Info> list;

	public List<? extends Info> getList() {
		return list;
	}

	public void setList(List<? extends Info> list) {
		this.list = list;
	}
	
	
}
