package com.hxzy.entity;

import java.util.Date;

public class CinemaFilmRelation {
	private int rNo;
	private Cinema cinema;
	private Film film;
	private Date date;/*��ӳʱ��*/
	private int state;	//״̬ 0�¼�   1��ӳ
	public Cinema getCinema() {
		return cinema;
	}
	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public int getrNo() {
		return rNo;
	}
	public void setrNo(int rNo) {
		this.rNo = rNo;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "CinemaFileRelation [cinema=" + cinema + ", film=" + film + "]";
	}
	
}
