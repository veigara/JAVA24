package com.hxzy;

/**
 * 电影院对具体某部电影的场次时间表
 * @author Administrator
 *
 */
public class FilmList {
	private Film film;//场次信息对应的电影
	private FilmItem[] list;//电影对应的排的时间表及放映厅
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public FilmItem[] getList() {
		return list;
	}
	public void setList(FilmItem list) {
		if (this.list == null) {
			this.list = new FilmItem[500]; 
			this.list[0] = list;
			return;
		}
		
		for (int i = 0; i < this.list.length; i++) {
			if (this.list[i] == null) {
				this.list[i] = list;
				return;
			}
		}
	}
	
	
}
