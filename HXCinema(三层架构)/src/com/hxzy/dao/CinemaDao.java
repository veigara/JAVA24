package com.hxzy.dao;

import java.util.List;

import com.hxzy.entity.Cinema;

public interface CinemaDao extends CommonDao<Cinema>{
	public List<Cinema> querybyFilmName(String filmName);
}
