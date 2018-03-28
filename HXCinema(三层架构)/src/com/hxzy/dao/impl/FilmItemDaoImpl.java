package com.hxzy.dao.impl;

import java.util.List;
import java.util.Map;

import com.hxzy.dao.FilmItemDao;
import com.hxzy.entity.FilmItem;
import com.hxzy.util.BaseDao;

public class FilmItemDaoImpl extends BaseDao implements FilmItemDao {

	@Override
	public int insert(FilmItemDao t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(FilmItemDao t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(FilmItemDao t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FilmItemDao findById(FilmItemDao t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	
	
	public List<FilmItemDao> query(int page, int pageSize, Map<String, Object> map) {
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
	 * 根据电影名称和电影院查询排场信息
	 * fno 电影的编号
	 */
	public List<FilmItem> queryByfnamecname(int fno, String CinemaName) {
		String sql="select fi.itemno itemo,fi.rno rno,fi.time time,fi.language language, fi.hourse hourse ,fi.price price from filmitem fi inner join cinema_film_relation cf on fi.rno=cf.rno inner join cinema c on c.cno=cf.cno where c.`name`= ? and cf.fno= ? ";
		Object [] params= {CinemaName,fno};
		return this.query(FilmItem.class, sql, params);
	}

	@Override
	public List<String> query(int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
