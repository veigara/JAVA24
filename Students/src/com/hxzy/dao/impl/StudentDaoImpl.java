package com.hxzy.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hxzy.biz.StudentBizImplTest;
import com.hxzy.dao.StudentDao;
import com.hxzy.entity.Student;
import com.hxzy.util.DataSourceUtil;

public class StudentDaoImpl implements StudentDao {

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
		String sql = "select studentno stuNo,studentName stuName,sex,identityCard from students where 1=1 ";
		StringBuilder sb = new StringBuilder(sql);
		int i = 0;
		Object[] params = null;
		if (map != null) {
			params = new Object[map.size()];
			for (String key : map.keySet()) {
				sb.append(" and" + key + "=? ");
				params[i++] = map.get(key);
			}
		}
		QueryRunner runner = new QueryRunner(DataSourceUtil.getDataSource());
		try {
			return runner.query(sql, new BeanListHandler<>(Student.class),params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int total(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Student login(String idCard, String loginPwd) {
		String sql = "select studentno stuNo,studentName stuName,sex,identityCard from students where identityCard = ? and loginpwd = ?";
		Object[] params = {idCard,loginPwd};
		
		QueryRunner runner = new QueryRunner(DataSourceUtil.getDataSource());
		try {
			return runner.query(sql, new BeanHandler<>(Student.class),params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
