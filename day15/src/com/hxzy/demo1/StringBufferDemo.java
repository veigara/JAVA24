package com.hxzy.demo1;

public class StringBufferDemo {

	public static void main(String[] args) {
		/*
		 * StringBuffer sb = new StringBuffer();
		 * StringBuffer sb = new StringBuffer(50);
		 * StringBuffer sb = new StringBuffer("����");
		 * */
		
		/*StringBuffer sb = new StringBuffer("���컪����ԭ");
		sb.append("\n������2017���ٷżٵ�֪ͨ��");
		sb.append("\tһ���ż�ʱ��");
		sb.append("\t\t2018��2��10����-2018��2��22��");
		
		System.out.println(sb.toString());*/
		
		/*��ʽ���*/
		StringBuffer sb = new StringBuffer("���컪����ԭ");
		sb.append("\n������2017���ٷżٵ�֪ͨ��")
			.append("\tһ���ż�ʱ��")
			.append("\t\t2018��2��10����-2018��2��22��");
		sb.insert(5, "�ش�ͬ��֪ͨ");//��ָ�����±괦�����ַ���
		sb.reverse();//��ת�ַ���
		/*
		 * sb.delete(int startIndex,int endIndex);  ɾ��ָ��������ַ���
		 * */
		System.out.println(sb.toString());
		
		
	}

}
