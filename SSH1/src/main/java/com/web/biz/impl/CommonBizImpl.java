package com.web.biz.impl;

import java.util.Map;

import com.web.biz.CommonBiz;
import com.web.dao.CommonDao;
import com.web.util.PageUtil;


public abstract class CommonBizImpl<T> implements CommonBiz<T> {

	CommonDao<T> commonDao;
	
	public void setCommonDao(CommonDao<T> commonDao) {
		this.commonDao = commonDao;
	}

	public boolean add(T obj){
		return commonDao.add(obj);
	}
	
	public void pagingQuery(PageUtil<T> paging,Map<String,Object> params){
		paging.setData(commonDao.pagingData(paging, params));
		paging.setTotalCount(commonDao.pagingTotalCount(params));
	}
}
