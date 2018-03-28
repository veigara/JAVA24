package com.hxzy.dao;

import java.util.List;
import java.util.Map;

/**
 * 通用的包含增，删，改，根据主键查询，分页查询,结合分页查询总共有多少条数据，的接口
 * @author Administrator
 *
 * @param <T>
 */
public interface CommonDao<T> {
	/**
	 * 通用的新增方法
	 * @param t
	 * @return
	 */
	public int insert(T t);
	
	/**
	 * 通用的修改方法
	 * @param t
	 * @return
	 */
	public int update(T t);
	
	/**
	 * 通用的删除方法
	 * @param t
	 * @return
	 */
	public int delete(T t);
	
	/**
	 * 根据主键查询当个对象
	 * @param t
	 * @return
	 */
	public T findById(T t);
	
	/**
	 * 分页查询
	 * @param params   查询条件
	 * @return
	 */
	public List<T> query(Map<String,Object> map);
	
	/**
	 * 查询满足sql条件的总共有多少条数据
	 * Math.ceil(数组总数 / 每页显示的条数 ) = 总的页数
	 * @param sql
	 * @param params
	 * @return
	 */
	public int total(Map<String,Object> map);
}
