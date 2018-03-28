package com.hxzy2;

import java.util.ArrayList;
import java.util.List;

/**
 * ��ӰԺ����
 * ����������������ĳ����ӰԺ
 * Cinema wanDa = new Cinema();
 * Cinema UME = new Cinema();
 * @author Administrator
 *
 */
public class Cinema {
	private String name;//ӰԺ����
	private List<FilmList> list;//��ǰ��ӰԺ������ӳ�ĵ�Ӱ��Ϣ
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
	 * �������ĵ�ӰԺ��û����ӵ�Ӱ�ų���Ϣ������������飬����Ӹ��ų���Ϣ������0�±�
	 * 
	 * �������Ķ����Ѿ�����˵�Ӱ�ų���Ϣ����Ӧ�����ų���Ϣ�������׷���ų� 
	 * @param list ׷���ų���Ϣ
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
