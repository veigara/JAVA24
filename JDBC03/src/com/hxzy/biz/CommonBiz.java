package com.hxzy.biz;

import java.util.List;
import java.util.Map;

public interface CommonBiz<T> {
	/**
	 * ͨ�õ���������
	 * @param t
	 * @return
	 */
	public int insert(T t);
	
	/**
	 * ͨ�õ��޸ķ���
	 * @param t
	 * @return
	 */
	public int update(T t);
	
	/**
	 * ͨ�õ�ɾ������
	 * @param t
	 * @return
	 */
	public int delete(T t);
	
	/**
	 * ����������ѯ��������
	 * @param t
	 * @return
	 */
	public T findById(T t);
	
	/**
	 * ��ҳ��ѯ
	 * @param page	ҳ��
	 * @param pageSize ÿҳ��ʾ������
	 * @param params   ��ѯ����
	 * @return
	 */
	public List<T> query(int page,int pageSize,Map<String,Object> map);
	
	/**
	 * ��ѯ����sql�������ܹ��ж���������
	 * Math.ceil(�������� / ÿҳ��ʾ������ ) = �ܵ�ҳ��
	 * @param sql
	 * @param params
	 * @return
	 */
	public int total(Map<String,Object> map);
}
