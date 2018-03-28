package com.hxzy.biz.impl;

import java.util.List;
import java.util.Map;

import com.hxzy.biz.StudentBiz;
import com.hxzy.dao.StudentDao;
import com.hxzy.dao.impl.StudentDaoImpl;
import com.hxzy.entity.Student;

public class StudentBizImpl implements StudentBiz{
	private StudentDao dao = new StudentDaoImpl();  //引用数据访问层的对象。三层架构，业务逻辑层调用数据访问层

	@Override
	public int insert(Student t) {
		return dao.insert(t);
	}

	@Override
	public int update(Student t) {
		return dao.update(t);
	}

	@Override
	public int delete(Student t) {
		return dao.delete(t);
	}

	@Override
	public Student findById(Student t) {
		return dao.findById(t);
	}

	@Override
	public List<Student> query(int page, int pageSize, Map<String, Object> map) {
		return dao.query(page, pageSize, map);
	}

	@Override
	public int total(Map<String, Object> map) {
		return dao.total(map);
	}

	@Override
	public int deleteByIdCard(String idCard) {
		return dao.deleteByIdCard(idCard);
	}
	
}
