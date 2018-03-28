package com.hxzy2;

import java.util.ArrayList;
import java.util.List;

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
	private List<FilmList> list;//当前电影院正在上映的电影信息
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<FilmList> getList() {
		return list;
	}
	
	/**
	 * 如果本类的电影院还没有添加电影排场信息，则添加是数组，并添加该排场信息至数组0下标
	 * 
	 * 如果本类的对象已经添加了电影排场信息，则应该在排场信息的数组后追加排场 
	 * @param list 追加排场信息
	 */
	public void setList(FilmList filmList) {
		if (list == null) {
			list = new ArrayList<>();
		}
		this.list.add(filmList);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Cinema other = (Cinema) obj;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
