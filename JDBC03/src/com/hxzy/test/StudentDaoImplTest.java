package com.hxzy.test;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.hxzy.dao.impl.StudentDaoImpl;
import com.hxzy.entity.Student;

class StudentDaoImplTest {

	private StudentDaoImpl impl = new StudentDaoImpl();
	
	@Test
	void test() {
		Map<String, Object> map = new HashMap<>();
		map.put("type", 4);
		//map.put("student_name", "张锋");
		
		int total = impl.total(map);
		
		int page = 1,pageSize = 5;
		int totalPages = (int) Math.ceil((double)total / pageSize);
		System.out.println("总共有：" + total + "条数据" + ",当前页码" + page + ",总共" + totalPages + "页");
		
		List<Student> list = impl.query(page, pageSize, map);
		for (Student s : list) {
			System.out.println(s);
		}
		
		
	}

}
