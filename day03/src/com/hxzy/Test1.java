package com.hxzy;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// 声明循环变量
		String loginName = null;
		String loginPwd = null;
		int count = 3;
		boolean flag = true;// 默认循环执行下去
		do {
			System.out.println("请输入用户名");
			loginName = input.next();

			System.out.println("请输入密码");
			loginPwd = input.next();

			if (loginName.equals("admin") && loginPwd.equals("123456")) {
				// 登录成功
				System.out.println("登录成功，欢迎" + loginName + "！");
				flag = false;
			} else {
				if (count <= 1) {
					System.out.println("账户被锁定");
					flag = false;// 账户被锁定后，循环结束
				} else {
					System.out.println("用户名或密码错误，还有" + --count + "次机会");
				}
			}
		} while (flag);
		input.close();
	}
}
