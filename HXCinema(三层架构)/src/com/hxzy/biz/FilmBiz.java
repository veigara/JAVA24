package com.hxzy.biz;

import java.util.List;

import com.hxzy.entity.Film;

public interface FilmBiz extends CommonBiz<Film> {
	/**
	 *  根据电影名称查询电影信息
	 * @param name
	 * @return
	 */
	public Film queryByName(String name);
	
	public List<Film> query(int page, int pageSize);
	public int total();
}
