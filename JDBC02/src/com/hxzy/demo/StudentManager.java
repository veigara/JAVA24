package com.hxzy.demo;

import java.util.List;

public class StudentManager extends BaseDao {

	/**
	 * 新增学生
	 * @param stu
	 * @return
	 */
	public int insert(Student stu) {
		String sql = "insert into `examstudent` (type,id_card,exam_card,student_name,location,grade) values(?,?,?,?,?,?)";
		Object[] params = {stu.getType(),stu.getIdCard(),stu.getExamCard(),stu.getStudentName(),stu.getLocation(),stu.getGrade()};
		return super.executeUpdate(sql, params);
	}
	
	/**
	 * 修改学生
	 * @param stu
	 * @return
	 */
	public int update(Student stu) {
		String sql = "update `examstudent` set type=?,id_card=?,exam_card=?,student_name=?,location=?,grade=? where flow_id=?";
		Object[] params = {stu.getType(),stu.getIdCard(),stu.getExamCard(),stu.getStudentName(),stu.getLocation(),stu.getGrade(),stu.getFlowId()};
		return super.executeUpdate(sql, params);
	}
	
	/**
	 * 根据考号删除学生
	 * @param stu
	 * @return
	 */
	public int remove(Student stu) {
		String sql = "delete from `examstudent` where exam_card = ?";
		return super.executeUpdate(sql, stu.getExamCard());
	}
	
	/**
	 * 根据类型查询学生
	 * @param type
	 * @return
	 */
	public List<Student> query(int type){
		String sql = "select flow_id flowId,type type,id_card idCard,exam_Card examCard,student_Name studentName,location location,grade grade from `examstudent` where type=?";
		return super.query(Student.class, sql, type);
	}
}
