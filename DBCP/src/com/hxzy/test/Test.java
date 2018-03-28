package com.hxzy.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test {

	public static void main(String[] args) {
		try {
			InputStream in=new FileInputStream("");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
