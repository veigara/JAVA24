package com.hxzy.biz;

import com.hxzy.entity.Student;

public interface StudentBiz extends CommonBiz<Student>{
	/**
	 * �������֤ɾ��ѧ����Ϣ
	 * @param idCard
	 * @return
	 */
	public int deleteByIdCard(String idCard);
}
