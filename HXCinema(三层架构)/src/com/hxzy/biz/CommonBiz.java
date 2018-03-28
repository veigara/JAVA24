package com.hxzy.biz;

import java.util.List;
import java.util.Map;

public interface CommonBiz<T> {
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
	 * @param page	页码
	 * @param pageSize 每页显示的条数
	 * @param params   查询条件
	 * @return
	 */
	public List<T> query(int page,int pageSize,Map<String,Object> map);
	
	/**
	 * 查询满足sql条件的总共有多少条数据
	 * Math.ceil(数组总数 / 每页显示的条数 ) = 总的页数
	 * @param sql
	 * @param params
	 * @return
	 */
	public int total(Map<String,Object> map);
}
