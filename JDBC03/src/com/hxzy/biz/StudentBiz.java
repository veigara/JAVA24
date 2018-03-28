package com.hxzy.biz;

import com.hxzy.entity.Student;

public interface StudentBiz extends CommonBiz<Student>{
	/**
	 * 根据身份证删除学生信息
	 * @param idCard
	 * @return
	 */
	public int deleteByIdCard(String idCard);
}
