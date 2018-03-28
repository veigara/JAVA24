package com.hxzy.biz.impl;

import java.util.List;
import java.util.Map;

import com.hxzy.biz.FilmItemBiz;
import com.hxzy.dao.FilmItemDao;
import com.hxzy.dao.impl.FilmItemDaoImpl;
import com.hxzy.entity.FilmItem;

public class FilmItemBizImpl implements FilmItemBiz {
	private FilmItemDao dao =new FilmItemDaoImpl();
	@Override
	public int insert(Object t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Object t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Object t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object findById(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List query(int page, int pageSize, Map map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int total(Map map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<FilmItem> queryByfnamecname(int fno, String CinemaName) {
		
		return dao.queryByfnamecname(fno, CinemaName);
	}

}
