package com.hxzy;

/**
 * ��ӰԺ�Ծ���ĳ����Ӱ�ĳ���ʱ���
 * @author Administrator
 *
 */
public class FilmList {
	private Film film;//������Ϣ��Ӧ�ĵ�Ӱ
	private FilmItem[] list;//��Ӱ��Ӧ���ŵ�ʱ�����ӳ��
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
