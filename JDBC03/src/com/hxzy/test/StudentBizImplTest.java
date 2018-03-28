package com.hxzy.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.hxzy.biz.StudentBiz;
import com.hxzy.biz.impl.StudentBizImpl;
import com.hxzy.entity.Student;

public class StudentBizImplTest {

	private StudentBiz biz = new StudentBizImpl();
	
	@Test
	public void insert() {
		Student stu = new Student(4, "100824195263214587", "200523164754008", "张丹山", "重庆", 86);
		int row = biz.insert(stu);
		assertEquals(1, row);
	}
	
	@Test
	public void update() {
		Student stu = new Student(4,6, "100824195263214584", "200523164754003", "赵虎子", "哈尔冰", 95);
		int row = biz.update(stu);
		assertEquals(1, row);
	}
	
	@Test
	public void delete() {
		fail("未通过测试");
	}
}
