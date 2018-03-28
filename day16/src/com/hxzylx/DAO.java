package com.hxzylx;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class DAO<T> {
	private  Map<String,T> map;
	/**
	 * ���� T ���͵Ķ��� Map ��Ա������
	 * @param id
	 * @param entity
	 */
	
	public void save(String id,T entity) {
		this.map.put(id,  entity);
	}
	public Map<String, T> getMap() {
		return map;
	}
	public void setMap(Map<String, T> map) {
		this.map = map;
	}
	/**
	 * �� map �л�ȡ id ��Ӧ�Ķ���
	 * @param id
	 * @return
	 */
	
	public T get(String id) {
		T t = this.map.get(id);
		
		return t;
		
	}
	/**
	 * �滻 map ��keyΪid������,��Ϊ entity ����
	 * @param id
	 * @param entity
	 */
	public void update(String id,T entity) {
		this.map.replace(id, entity);
	}
	/**
	 * ���� map �д�ŵ����� T ����
	 * @return
	 */
	public List<T> list(){
		Collection<T> values = this.map.values();
		List<T> list=new  ArrayList<T>();
		Iterator<T> it = values.iterator();
		while(it.hasNext()) {
			list.add(it.next());
		}
		return  list;
	}
	public void delete(String id) {
		this.map.remove(id);
	}
	
	
	
	
}
