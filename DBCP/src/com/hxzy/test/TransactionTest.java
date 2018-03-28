package com.hxzy.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.hxzy.util.BaseDao;

public class TransactionTest extends BaseDao{

	@Test
	public void test() {
		String sql1 = "delete from result where studentno = ?";
		String sql2 = "delete from students where studentno = ?";
List<Map<String, Object>> list = new ArrayList<>();
		
		Map<String, Object> map1 = new HashMap<>();
		map1.put("sql", sql1);
		map1.put("param", new Object[] {3}); //删除成绩表中学号为3的信息
		
		Map<String, Object> map2 = new HashMap<>();
		map2.put("sql", sql2);
		map2.put("param", new Object[] {3}); //删除学生表中，学号为3的信息
		list.add(map1);
		list.add(map2);
		
		boolean result = super.doTransaction(list);
		
		assertTrue(result);
	}

}
