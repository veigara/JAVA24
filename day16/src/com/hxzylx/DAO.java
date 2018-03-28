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
	 * 保存 T 类型的对象到 Map 成员变量中
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
	 * 从 map 中获取 id 对应的对象
	 * @param id
	 * @return
	 */
	
	public T get(String id) {
		T t = this.map.get(id);
		
		return t;
		
	}
	/**
	 * 替换 map 中key为id的内容,改为 entity 对象
	 * @param id
	 * @param entity
	 */
	public void update(String id,T entity) {
		this.map.replace(id, entity);
	}
	/**
	 * 返回 map 中存放的所有 T 对象
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
