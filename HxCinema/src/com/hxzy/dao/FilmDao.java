package com.hxzy.dao;

import com.hxzy.entity.Film;

public interface FilmDao extends CommonDao<Film> {
	/**
	 * ���ݵ�Ӱ���Ʋ�ѯ��Ӱ��Ϣ
	 * @param name
	 * @return
	 */
	public Film queryByName(String name);
}
