package com.hxzy.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.hxzy.dao.StudentDao;
import com.hxzy.entity.Student;
import com.hxzy.util.DataSourceUtil;

public class StudentDaoImpl implements StudentDao {

	private QueryRunner runner = new QueryRunner(DataSourceUtil.getDataSource());
	
	@Override
	public int insert(Student stu) {
		String sql = "insert into `examstudent` (type,id_card,exam_card,student_name,location,grade) values(?,?,?,?,?,?)";
		Object[] params = {stu.getType(),stu.getIdCard(),stu.getExamCard(),stu.getStudentName(),stu.getLocation(),stu.getGrade()};
		try {
			return runner.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Student querySingle(int studentNo) {
		String sql = "select flow_id flowId,type type,id_card idCard,exam_Card examCard,student_Name studentName,location location,grade grade from `examstudent` where studentno=?";
		Object[] params = {studentNo};
		try {
			Student student = runner.query(sql,new BeanHandler<>(Student.class),params);
			System.out.println(student);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Student> queryAll() {
		String sql = "select flow_id flowId,type type,id_card idCard,exam_Card examCard,student_Name studentName,location location,grade grade from `examstudent`";
		try {
			return runner.query(sql, new BeanListHandler<>(Student.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public  List<Map<String, Object>>  queryListMap() {
		String sql = "select flow_id flowId,type type,id_card idCard,exam_Card examCard,student_Name studentName,location location,grade grade from `examstudent`";
		try {
			return runner.query(sql, new MapListHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
