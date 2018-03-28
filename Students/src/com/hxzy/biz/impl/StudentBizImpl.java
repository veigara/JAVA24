package com.hxzy.biz.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import com.hxzy.biz.StudentBiz;
import com.hxzy.dao.StudentDao;
import com.hxzy.dao.impl.StudentDaoImpl;
import com.hxzy.entity.Student;
import com.hxzy.util.MD5Util;

public class StudentBizImpl implements StudentBiz {

	private StudentDao dao = new StudentDaoImpl();
	
	@Override
	public int insert(Student t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Student t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Student t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Student findById(Student t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> query(Map<String, Object> map) {
		return dao.query(map);
	}

	@Override
	public int total(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Student login(String idCard, String loginPwd) {
		/*加密密码*/
		try {
			return dao.login(idCard, MD5Util.MD5(loginPwd));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
