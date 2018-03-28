package com.hxzy.biz;

import java.util.List;

import com.hxzy.entity.Cinema;

public interface CinemaBiz  extends CommonBiz<Cinema>{
	public List<Cinema> querybyFilmName(String filmName);
}
