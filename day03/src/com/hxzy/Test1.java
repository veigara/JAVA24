package com.hxzy;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// ����ѭ������
		String loginName = null;
		String loginPwd = null;
		int count = 3;
		boolean flag = true;// Ĭ��ѭ��ִ����ȥ
		do {
			System.out.println("�������û���");
			loginName = input.next();

			System.out.println("����������");
			loginPwd = input.next();

			if (loginName.equals("admin") && loginPwd.equals("123456")) {
				// ��¼�ɹ�
				System.out.println("��¼�ɹ�����ӭ" + loginName + "��");
				flag = false;
			} else {
				if (count <= 1) {
					System.out.println("�˻�������");
					flag = false;// �˻���������ѭ������
				} else {
					System.out.println("�û�����������󣬻���" + --count + "�λ���");
				}
			}
		} while (flag);
		input.close();
	}
}
