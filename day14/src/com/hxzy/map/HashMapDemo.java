package com.hxzy.map;

import java.io.ObjectOutputStream.PutField;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.hxzy.comparable.Food;

public class HashMapDemo {

	public static void main(String[] args) {
		//K:key
		//V:value
		/*
		 * 告诉map集合，键是什么类型，值是什么类型
		 * */
		Map<String, Food> map = new HashMap<String, Food>();
		
		add(map);
		//foreach(map);
		//values(map);
		//key(map);
		entrySet(map);
	}

	/**
	 * 向map中添加数据
	 * @param map
	 */
	@SuppressWarnings({ "serial", "rawtypes", "unchecked" })
	private static void add(Map<String, Food> map) {
		map.put("牛肉干", new Food("灯影牛肉", 30));
		map.put("泡椒风爪", new Food("有友", 10));
		map.put("豆腐干", new Food("奇爽", 2));
		
		Food remove = map.remove("辣条");//根据键移除对象
		
		
		/**/
		Map<String, Food> map2 = new HashMap() {{
			put("辣条", new Food("卫东", 5));
			put("棒棒冰", new Food("棒棒冰", .1));
			put("豆腐干", new Food("奇爽", 3));
		}} ;
		
		map.putAll(map2);
	}
	
	/**
	 * 迭代map集合
	 * @param map
	 */
	private static void foreach(Map<String, Food> map) {
		/*
		 * 遍历map，通常根据keySet()得到map的键的集合。然后根据键获取值
		 * */
		for (String key:map.keySet()) {
			//System.out.println(key);
			Food food = map.get(key);
			System.out.println(food.toString());
		}
		
	}
	
	private static void key(Map<String, Food> map) {
		for (String key:map.keySet()) {
			System.out.println("key:" + key);
		}
	}
	
	private static void values(Map<String, Food> map) {
		Collection<Food> values = map.values();
		for (Food food : values) {
			System.out.println(food.toString());
		}
	}
	
	private static void entrySet(Map<String, Food> map) {
		Set<Entry<String, Food>> entrySet = map.entrySet();
		for (Entry<String, Food> e : entrySet) {
			String key = e.getKey();
			Food value = e.getValue();
			System.out.println("key:" + key + ",value:" + value);
		}
	}
	

}
