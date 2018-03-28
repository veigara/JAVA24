package com.hxzy.dao;

import java.util.List;
import java.util.Map;

import com.hxzy.entity.Film;

public interface FilmDao extends CommonDao<Film> {
	/**
	 * ���ݵ�Ӱ���Ʋ�ѯ��Ӱ��Ϣ
	 * @param name
	 * @return
	 */
	public Film queryByName(String name);
	/**
	 * �鿴���еĵ�Ӱ����
	 * @param pageҳ��
	 * @param pageSize��ʾ������
	 * @return
	 */
	public List<Film> query(int page, int pageSize);
	/**
	 * ��ʾ���еĵ�Ӱ����
	 * @return
	 */
	public int total();
	
}
