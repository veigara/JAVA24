package com.hxzy.biz;

import static org.junit.Assert.*;

import org.junit.Test;

import com.hxzy.biz.impl.StudentBizImpl;
import com.hxzy.entity.Student;

public class StudentBizImplTest {

	private StudentBiz biz = new StudentBizImpl();
	
	@Test
	public void login() {
		Student stu = biz.login("zhangsan", "admin");
		assertNotNull(stu);
	}

}
