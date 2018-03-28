package com.hxzy.dao;

import java.util.List;
import java.util.Map;

import com.hxzy.entity.Film;
import com.hxzy.entity.FilmItem;

public interface FilmItemDao extends CommonDao<FilmItemDao> {
	/**
	 * ���ݵ�Ӱ���ƺ͵�ӰԺ��ѯ�ų���Ϣ
	 * @param fno��Ӱ���
	 * @param CinemaName
	 * @return
	 */
	public List<FilmItem> queryByfnamecname(int fno,String CinemaName );
	/**
	 * ��ѯȫ����Ӱ����
	 * @param pageҳ��
	 * @param pageSize
	 * @return
	 */
	public List<String> query(int page, int pageSize);
}
