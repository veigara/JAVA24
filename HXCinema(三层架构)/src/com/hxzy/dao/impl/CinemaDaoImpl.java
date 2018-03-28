package com.hxzy.dao.impl;

import java.util.List;
import java.util.Map;

import com.hxzy.dao.CinemaDao;
import com.hxzy.entity.Cinema;
import com.hxzy.util.BaseDao;

public class CinemaDaoImpl extends BaseDao implements CinemaDao {

	@Override
	public int insert(Cinema t) {
		return 0;
	}

	@Override
	public int update(Cinema t) {
		return 0;
	}

	@Override
	public int delete(Cinema t) {
		return 0;
	}

	@Override
	public Cinema findById(Cinema t) {
		return null;
	}

	@Override
	public List<Cinema> query(int page, int pageSize, Map<String, Object> map) {
		return null;
	}

	@Override
	public int total(Map<String, Object> map) {
		return 0;
	}
	@Override
	/**
	 * 根据电影名称查询所有的电影院
	 */
	public List<Cinema> querybyFilmName(String filmName) {
		String sql="select c.cno no,c.name name from cinema c inner join cinema_film_relation cr on c.cno=cr.cno inner join film f on cr.fno=f.fno where f.name=? ";
	
		return this.query(Cinema.class, sql, filmName);
	}
}
