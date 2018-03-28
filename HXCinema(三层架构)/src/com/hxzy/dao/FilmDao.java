package com.hxzy.dao;

import java.util.List;
import java.util.Map;

import com.hxzy.entity.Film;

public interface FilmDao extends CommonDao<Film> {
	/**
	 * 根据电影名称查询电影信息
	 * @param name
	 * @return
	 */
	public Film queryByName(String name);
	/**
	 * 查看所有的电影名称
	 * @param page页码
	 * @param pageSize显示的条数
	 * @return
	 */
	public List<Film> query(int page, int pageSize);
	/**
	 * 显示所有的电影条数
	 * @return
	 */
	public int total();
	
}
