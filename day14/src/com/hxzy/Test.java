package com.hxzy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		/*try {
			FileInputStream f = new FileInputStream("/test.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}*/
		//System.out.println(System.getProperty("user.dir"));
		String str = "��";
		String str2 = "��";
		String str3 = new String("��");
		System.out.println(str == str2);
		System.out.println(str == str3);
	}

}
