package com.hxzy2;

import java.util.ArrayList;
import java.util.List;

/**
 * ��ӰԺ�Ծ���ĳ����Ӱ�ĳ���ʱ���
 * @author Administrator
 *
 */
public class FilmList {
	private Film film;//������Ϣ��Ӧ�ĵ�Ӱ
	private List<FilmItem> list;//��Ӱ��Ӧ���ŵ�ʱ�����ӳ��
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
