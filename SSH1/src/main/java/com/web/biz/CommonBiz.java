package com.web.biz;

import java.util.Map;

import com.web.util.PageUtil;

public interface CommonBiz<T> {
	public boolean add(T obj);
	
	public void pagingQuery(PageUtil<T> paging,Map<String,Object> params);
}
