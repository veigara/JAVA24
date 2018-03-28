package com.hxzy.dao;

import java.util.List;
import java.util.Map;

import com.hxzy.entity.Film;
import com.hxzy.entity.FilmItem;

public interface FilmItemDao extends CommonDao<FilmItemDao> {
	/**
	 * 根据电影名称和电影院查询排场信息
	 * @param fno电影编号
	 * @param CinemaName
	 * @return
	 */
	public List<FilmItem> queryByfnamecname(int fno,String CinemaName );
	/**
	 * 查询全部电影名称
	 * @param page页码
	 * @param pageSize
	 * @return
	 */
	public List<String> query(int page, int pageSize);
}
