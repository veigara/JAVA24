package com.hxzy.dao.impl;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

import com.hxzy.entity.Student;

public class StudentDaoImplTest extends StudentDaoImpl{

	@Test
	@Ignore
	public void test() {
		fail("Not yet implemented");
	}

	@Ignore
	public void insert() {
		//super.insert(stu);
	}
	
	@Test
	public void querySingle() {
		Student stu = super.querySingle(1);
		System.out.println(stu);
		assertNotNull(stu);

	}
	
	/*@Test
	public void queryAll() {
		List<Student> list = super.queryAll();
		assertTrue(list.size() > 0);
	}
	
	public void queryListMap() {
		List<Map<String, Object>> map = super.queryListMap();
	}*/
}
