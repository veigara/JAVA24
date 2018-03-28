package com.hxzylx;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Client {
	public static void main(String[] args) {
		 DAO<String> dao = new DAO<String>();
		Map<String, String> map = new HashMap<String, String>();
		map.put("wang1", "1");
		map.put("wang2", "2");
		map.put("wang3", "3");
		map.put("wang4", "4");
		dao.setMap(map);
		 display(dao);
		System.out.println("-----------------");
		dao.save("wang5", "5");
		display(dao);
		String string = dao.get("wang5");
		System.out.println();
		System.out.println(string);
		System.out.println("-----------------");
		dao.update("wang5", "3");
		String string1 = dao.get("wang5");
		System.out.println();
		System.out.println(string1);
		System.out.println("--------");
		
		List<String> list = dao.list();
			for (String string2 : (ArrayList<String>)list) {
				System.out.println(string2);
			}
		System.out.println("--------");	
		dao.delete("wang5");
		display(dao);
		 
	}

	private static void display(DAO<String> dao) {
		Set<Entry<String, String>> entrySet = dao.getMap().entrySet();
		for (Entry<String, String> entry : entrySet) {
			System.out.println("key:"+entry.getKey()+",value:"+entry.getValue());
		}
	}
}
