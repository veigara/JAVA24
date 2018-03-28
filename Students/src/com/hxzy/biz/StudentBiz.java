package com.hxzy.biz;

import com.hxzy.entity.Student;

public interface StudentBiz extends CommonBiz<Student> {
	/**
	 * 根据用户名和密码登录
	 * @param idCard
	 * @param loginPwd
	 * @return
	 */
	public Student login(String idCard,String loginPwd);
}
