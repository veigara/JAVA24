package com.hxzy;

/**
 * 电影院的类
 * 该类用于描述具体某个电影院
 * Cinema wanDa = new Cinema();
 * Cinema UME = new Cinema();
 * @author Administrator
 *
 */
public class Cinema {
	private String name;//影院名称
	private FilmList[] list;//当前电影院正在上映的电影信息
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public FilmList[] getList() {
		return list;
	}
	
	/**
	 * 如果本类的电影院还没有添加电影排场信息，则添加是数组，并添加该排场信息至数组0下标
	 * 
	 * 如果本类的对象已经添加了电影排场信息，则应该在排场信息的数组后追加排场 
	 * @param list 追加排场信息
	 */
	public void setList(FilmList list) {
		if (this.list == null) {
			this.list = new FilmList[500]; //如果本类的电影院还没有添加电影排场信息，则添加是数组，并添加该排场信息至数组0下标
			this.list[0] = list;
			return;
		}
		
		/*
		 * 如果上一步没有进入if，说明本类的对象已经添加了电影排场信息，则应该在排场信息的数组追加排场 
		 */
		for (int i = 0; i < this.list.length; i++) {
			if (this.list[i] == null) {
				this.list[i] = list;
				return;
			}
		}
	}
	
	
}
