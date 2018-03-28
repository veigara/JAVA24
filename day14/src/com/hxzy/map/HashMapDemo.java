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
		 * ����map���ϣ�����ʲô���ͣ�ֵ��ʲô����
		 * */
		Map<String, Food> map = new HashMap<String, Food>();
		
		add(map);
		//foreach(map);
		//values(map);
		//key(map);
		entrySet(map);
	}

	/**
	 * ��map���������
	 * @param map
	 */
	@SuppressWarnings({ "serial", "rawtypes", "unchecked" })
	private static void add(Map<String, Food> map) {
		map.put("ţ���", new Food("��Ӱţ��", 30));
		map.put("�ݽ���צ", new Food("����", 10));
		map.put("������", new Food("��ˬ", 2));
		
		Food remove = map.remove("����");//���ݼ��Ƴ�����
		
		
		/**/
		Map<String, Food> map2 = new HashMap() {{
			put("����", new Food("����", 5));
			put("������", new Food("������", .1));
			put("������", new Food("��ˬ", 3));
		}} ;
		
		map.putAll(map2);
	}
	
	/**
	 * ����map����
	 * @param map
	 */
	private static void foreach(Map<String, Food> map) {
		/*
		 * ����map��ͨ������keySet()�õ�map�ļ��ļ��ϡ�Ȼ����ݼ���ȡֵ
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
