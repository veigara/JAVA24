package com.hxzy2;

import java.util.ArrayList;
import java.util.List;

/**
 * 电影院对具体某部电影的场次时间表
 * @author Administrator
 *
 */
public class FilmList {
	private Film film;//场次信息对应的电影
	private List<FilmItem> list;//电影对应的排的时间表及放映厅
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public List<FilmItem> getList() {
		return list;
	}
	public void setList(FilmItem filmItem) {
		if (list == null) {
			list = new ArrayList<>();
		}
		list.add(filmItem);
	}
	
	
}
