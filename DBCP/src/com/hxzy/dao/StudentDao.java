package com.hxzy.dao;

import java.util.List;

import com.hxzy.entity.Student;

public interface StudentDao {
	public int insert(Student stu);
	
	public Student querySingle(int studentNo);
	
	public List<Student> queryAll();
}
