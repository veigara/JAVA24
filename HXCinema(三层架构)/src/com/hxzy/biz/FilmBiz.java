package com.hxzy.biz;

import java.util.List;

import com.hxzy.entity.Film;

public interface FilmBiz extends CommonBiz<Film> {
	/**
	 *  ���ݵ�Ӱ���Ʋ�ѯ��Ӱ��Ϣ
	 * @param name
	 * @return
	 */
	public Film queryByName(String name);
	
	public List<Film> query(int page, int pageSize);
	public int total();
}
