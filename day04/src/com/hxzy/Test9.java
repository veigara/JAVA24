package com.hxzy;

public class Test9 {

	public static void main(String[] args) {
		/*
		 * ��һ���ַ������ҵ�һ��ֻ���ֹ�һ�ε��ַ�
     �磺���롱azbaccdeff��,��ʾ��һ�����ֹ�һ�ε��ַ��ǣ� z

		 * */
		String str = "azbacchdefzfb";
		/*
		 * length()  �����ַ����ĳ���
		 * charAt()  ����ָ���������ַ�
		 * */
		for (int i = 0; i < str.length(); i++) {
			char item = str.charAt(i);
			boolean flag = true;//����
			for (int j = 0; j < str.length(); j++) {
				if (i == j) {
					continue;
				}
				char temp = str.charAt(j);
				if (item == temp) {
					flag = false;
					break;//�����ڲ�ѭ��
				}
			}
			if (flag) {
				System.out.println(item + "�ǵ�һ���ֵ�һ���ַ�");
				break;
			}
		}
	}

}
