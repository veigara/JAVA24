package com.hxzy.dao;

import com.hxzy.entity.Student;

/**
 * ��Studentʵ�����������
 * @author Administrator
 *
 */
public interface StudentDao extends CommonDao<Student>{
	/**
	 * �������֤ɾ��ѧ����Ϣ
	 * @param idCard
	 * @return
	 */
	public int deleteByIdCard(String idCard);
}
