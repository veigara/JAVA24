package com.hxzy.biz;

import java.util.List;


import com.hxzy.entity.FilmItem;

public interface FilmItemBiz extends CommonBiz{
	public List<FilmItem> queryByfnamecname(int fno,String CinemaName );
}
