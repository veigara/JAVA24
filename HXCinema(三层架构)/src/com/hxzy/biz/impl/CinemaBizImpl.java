package com.hxzy.biz.impl;

import java.util.List;
import java.util.Map;

import com.hxzy.biz.CinemaBiz;
import com.hxzy.dao.CinemaDao;
import com.hxzy.dao.impl.CinemaDaoImpl;
import com.hxzy.entity.Cinema;

public class CinemaBizImpl implements CinemaBiz {
	private CinemaDao dao=new CinemaDaoImpl();
	@Override
	public int insert(Cinema t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Cinema t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Cinema t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Cinema findById(Cinema t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cinema> query(int page, int pageSize, Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int total(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	/**
	 * 根据电影名称获得电影院
	 */
	public List<Cinema> querybyFilmName(String filmName) {
		
		return dao.querybyFilmName(filmName);
	}

}
