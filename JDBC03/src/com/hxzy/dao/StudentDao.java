package com.hxzy.dao;

import com.hxzy.entity.Student;

/**
 * 对Student实体类操作方法
 * @author Administrator
 *
 */
public interface StudentDao extends CommonDao<Student>{
	/**
	 * 根据身份证删除学生信息
	 * @param idCard
	 * @return
	 */
	public int deleteByIdCard(String idCard);
}
