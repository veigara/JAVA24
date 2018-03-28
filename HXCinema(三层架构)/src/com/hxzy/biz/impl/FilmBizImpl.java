package com.hxzy.biz.impl;

import java.util.List;
import java.util.Map;

import com.hxzy.biz.FilmBiz;
import com.hxzy.dao.FilmDao;
import com.hxzy.dao.impl.FilmDaoImpl;
import com.hxzy.entity.Film;

public class FilmBizImpl implements FilmBiz {
	private FilmDao dao =new FilmDaoImpl();
	@Override
	public int insert(Film t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Film t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Film t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Film findById(Film t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	/**
	 *  分页,根据条件查询电影信息
	 */
	public List<Film> query(int page, int pageSize, Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.query(page, pageSize, map);
	}

	@Override
	public int total(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.total(map);
	}

	@Override
	/**
	 * 根据电影名称查询电影信息
	 */	
	public Film queryByName(String name) {
	
		return dao.queryByName(name);
	}

	@Override
	public List<Film> query(int page, int pageSize) {
		
		return dao.query(page, pageSize);
	}

	@Override
	public int total() {
		
		return dao.total();
	}

}
