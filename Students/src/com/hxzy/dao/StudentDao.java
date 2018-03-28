package com.hxzy.dao;

import com.hxzy.entity.Student;

public interface StudentDao extends CommonDao<Student> {

	/**
	 * 根据用户名和密码登录
	 * @param idCard
	 * @param loginPwd
	 * @return
	 */
	public Student login(String idCard,String loginPwd);
}
