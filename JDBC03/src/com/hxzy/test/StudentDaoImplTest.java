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
		//map.put("student_name", "�ŷ�");
		
		int total = impl.total(map);
		
		int page = 1,pageSize = 5;
		int totalPages = (int) Math.ceil((double)total / pageSize);
		System.out.println("�ܹ��У�" + total + "������" + ",��ǰҳ��" + page + ",�ܹ�" + totalPages + "ҳ");
		
		List<Student> list = impl.query(page, pageSize, map);
		for (Student s : list) {
			System.out.println(s);
		}
		
		
	}

}
