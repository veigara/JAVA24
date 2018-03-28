package com.hxzy.demo1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {

	public static void main(String[] args) {
		Object[] objs = new Object[5];
		objs[0] = "hello";
		objs[1] = 10;
		objs[2] = new Double(20);
		objs[3] = new ArrayList<>();
		
		for (Object object : objs) {
			int i = (int) object;
		}
		
		List<String> list = new ArrayList<String>();
		list.add("");
		list.add(new String());
		
		Map<String,Object> map = new HashMap<>();
		map.put("", "");
		map.put("1", 1);
		map.put("2", 3.14);
		
	}

}
