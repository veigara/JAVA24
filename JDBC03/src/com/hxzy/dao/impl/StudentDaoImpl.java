package com.hxzy.dao.impl;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.hxzy.dao.StudentDao;
import com.hxzy.entity.Student;
import com.hxzy.util.BaseDao;

public class StudentDaoImpl extends BaseDao implements StudentDao{

	@Override
	public int insert(Student stu) {
		String sql = "insert into `examstudent` (type,id_card,exam_card,student_name,location,grade) values(?,?,?,?,?,?)";
		Object[] params = {stu.getType(),stu.getIdCard(),stu.getExamCard(),stu.getStudentName(),stu.getLocation(),stu.getGrade()};
		return super.executeUpdate(sql, params);
	}

	@Override
	public int update(Student stu) {
		String sql = "update `examstudent` set type=?,id_card=?,exam_card=?,student_name=?,location=?,grade=? where flow_id=?";
		Object[] params = {stu.getType(),stu.getIdCard(),stu.getExamCard(),stu.getStudentName(),stu.getLocation(),stu.getGrade(),stu.getFlowId()};
		return super.executeUpdate(sql, params);
	}

	@Override
	public int delete(Student stu) {
		String sql = "delete from `examstudent` where exam_card = ?";
		return super.executeUpdate(sql, stu.getExamCard());
	}

	@Override
	public Student findById(Student t) {
		String sql = "select flow_id flowId,type type,id_card idCard,exam_Card examCard,student_Name studentName,location location,grade grade from `examstudent` where id_card=?";
		List<Student> list = super.query(Student.class, sql, t.getIdCard());
		return list.size() > 0 ? list.get(0):null;//因为身份证不会重复，因此要么能查出一个人，要么查不出人
	}

	@Override
	public List<Student> query(int page, int pageSize, Map<String, Object> map) {
		String sql = "select flow_id flowId,type type,id_card idCard,exam_Card examCard,student_Name studentName,location location,grade grade from `examstudent` where 1 = 1 ";
		//where 1 = 1 and type = ? and flow_id = ? and studentname = ?
		StringBuilder sb = new StringBuilder(sql);
		Object[] params = null;
		if (map.size() > 0) {
			params = new Object[map.size()];
		}
		int i = 0;
		for (String key : map.keySet()) {
			sb.append("and " + key + "= ? ");
			params[i++] = map.get(key);
		}
		sb.append("limit " + (page - 1) * pageSize + "," + pageSize); //分页
		System.out.println(sb.toString());
		return super.query(Student.class, sb.toString(), params);
	}

	@Override
	public int total(Map<String, Object> map) {
		//只根据条件查询满足条件的数据条数
		String sql = "select count(*) from `examstudent` where 1 = 1 ";
		//where 1 = 1 and type = ? and flow_id = ? and studentname = ?
		StringBuilder sb = new StringBuilder(sql);
		Object[] params = null;
		if (map.size() > 0) {
			params = new Object[map.size()];
		}
		int i = 0;
		for (String key : map.keySet()) {
			sb.append("and " + key + "= ? ");
			params[i++] = map.get(key);
		}
		super.conn = super.getConnection();
		try {
			super.pstmt = super.conn.prepareStatement(sb.toString());
			if (null != params) {
				for (int j = 0; j < params.length; j++) {
					super.pstmt.setObject(j + 1, params[j]);
				}
			}
			super.rs = super.pstmt.executeQuery();
			if (super.rs.next()) {
				return super.rs.getInt(1);  //取单行单列的值,因为sql语句的count是一个聚合函数
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(super.conn, super.pstmt, super.rs);
		}
		return 0;
	}

	@Override
	public int deleteByIdCard(String idCard) {
		String sql = "delete from `examstudent` where id_card = ?";
		return super.executeUpdate(sql, idCard);
	}

}
