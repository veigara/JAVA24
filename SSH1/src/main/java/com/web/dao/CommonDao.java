package com.web.dao;

import java.util.List;
import java.util.Map;

import com.web.util.PageUtil;

public interface CommonDao<T> {

	public boolean add(T obj);
	
	public List<T> query(Map<String,Object> params);
	
	/**
	 * 分页查询得到数据
	 * @param paging
	 * @param params
	 * @return
	 */
	public List<T> pagingData(PageUtil<T> paging,Map<String,Object> params);
	
	/**
	 * 分页查询得到总条数
	 * @param params
	 * @return
	 */
	public Integer pagingTotalCount(Map<String,Object> params);
}
