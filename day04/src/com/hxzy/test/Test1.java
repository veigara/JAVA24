package com.hxzy.test;

import java.util.Arrays;

public class Test1 {

	public static void main(String[] args) {
		String str[] = {"AAA","AAB","AAA","AAC","AAC","AAC","BBC","BBD","AAC","DBB","AAE","AAD"};
		
		//method1(str);
		method2(str);
	}

	private static void method1(String[] str) {
		for (int i = 0; i < str.length - 1; i++) {
			for (int j = i + 1; j < str.length; j++) {
				//str[i] != null && str[j] != null && 
				if (str[i] != null && str[j] != null && str[i].equals(str[j])) {
					str[j] = null;
				}
			}
		}
		
		//[AAA, AAB, null, AAC, null, null, BBC, BBD, null, DBB, AAE, AAD]
		/*
		 * [AAA, AAB, null, AAC, null, null, BBC, BBD, null, DBB, AAE, AAD]
		 * 
		 * */
		for (int i = 0; i < str.length - 1; i++) {
			int null_index = i;
			for (int j = i; j < str.length; j++) {
				if (str[j] == null) {
					null_index = j;
					break;
				}
			}
			
			int index = i;
			for (int j = index + 1; j < str.length; j++) {
				if (str[j] != null) {
					index = j;
					break;
				}
			}
			
			String temp = str[index];
			str[index] = str[null_index];
			str[null_index] = temp;
		}
		
		
		System.out.println(Arrays.toString(str));
	}

	private static void method2(String[] str) {
		int count = 0;
		for (int i = 0; i < str.length - 1; i++) {
			for (int j = i + 1; j < str.length; j++) {
				//str[i] != null && str[j] != null && 
				if (str[i] != null && str[j] != null && str[i].equals(str[j])) {
					str[j] = null;
					count++;
				}
			}
		}
		
		String[] arr = new String[str.length - count];
		int index = 0;
		for (int i = 0; i < str.length; i++) {
			if (str[i] != null) {
				arr[index++] = str[i];
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
}
