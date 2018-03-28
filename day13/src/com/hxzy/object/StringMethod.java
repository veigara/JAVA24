package com.hxzy.object;

import java.util.Arrays;

public class StringMethod {

	public static String str = "abcdefghijklmnopqrstuvwxyz     abcdefghijklmnopqrstuvwxyz";
	public static void main(String[] args) {
		//length() �����ַ����ַ��ĸ���
		int length = str.length();
		System.out.println("str�ַ�����Ϊ��" + length);
		
		//charAt(�±�)  ��ȡָ���±���ַ�
		char c = str.charAt(str.length() - 1);
		System.out.println(c);
		
		//equals() �ַ�����ֵ�ж�
		System.out.println("equals��ֵ�жϣ�" + str.equals("abcdef"));
		
		//compareTo()  ���ֵ�˳��Ƚ��ַ���������int���͵�ֵ
		//�ȱȽ��ַ���С���򷵻ش���0��ֵ���ȱȽ��ַ������򷵻�С��0��ֵ������򷵻�0
		int result = "abc".compareTo("abe");
		System.out.println(result);
		
		/*
		 * indexOf(String)  ��ȡ�ַ����е�һ�γ���ָ���ַ������±�,-1����û�и��ַ���
		 * indexOf(int)    int����asc��     a:97   A:65		-1����û�и��ַ���
		 * indexOf(int ch,int fromIndex)   ��ָ���ַ����в�ѯch��asc�룬��fromIndex��ʼ��ѯ��  -1����û�и��ַ���
		 * indexOf(String,int fromIndex)   ��ָ���ַ����в�ѯָ�����ַ�������fromIndex��ʼ��ѯ��  -1����û�и��ַ���
		 * */
		int index = str.indexOf("z");
		System.out.println("z��str�е�һ�γ��ֵ��±꣺" + index);
		
		//System.out.println(str.indexOf(97));
		//System.out.println(str.indexOf(97, 10));
		
		
		/*
		 * lastIndexOf(String)  ����ָ���ַ������һ�γ��ֵ�λ�ã�-1����û�и��ַ���
		 * lastIndexOf(String)  ��ȡ�ַ��������һ�γ���ָ���ַ������±�,-1����û�и��ַ���
		 * lastIndexOf(int)    int����asc��     a:97   A:65		-1����û�и��ַ���
		 * lastIndexOf(int ch,int fromIndex)   ��ָ���ַ����в�ѯch��asc�룬��fromIndex��ʼ��ѯ��  -1����û�и��ַ���
		 * lastIndexOf(String,int fromIndex)   ��ָ���ַ����в�ѯָ�����ַ�������fromIndex��ʼ��ѯ��  -1����û�и��ַ���
		 * */
		System.out.println("a���һ�γ��ֵ�λ�ã�" + str.lastIndexOf("a"));
		
		//startWith(String)  �ж��ַ����Ƿ���ָ�����ַ�����ʼ,boolean
		System.out.println("str��abc��ʼ��" + str.startsWith("abc"));
		
		//endWith(String)  �ж��ַ�����ʲô����
		System.out.println("str��z������" + str.endsWith("z"));
		
		//regionMatches(boolean ,int,String,int ,int) �ж������ַ���ĳ����������ı��Ƿ���ͬ
		/*
		 * ����1���Ƿ���Դ�Сд
		 * ����2����һ���ַ��������￪ʼƥ��
		 * ����3��Ҫ���ĸ��ַ����Ƚ�
		 * ����4��Ҫ�ӱȽϵ��ַ������ĸ�λ�ÿ�ʼ
		 * ����5��ƥ����ٸ��ַ�
		 * */
		String str2 = "EFGHIJ";
		boolean bool = str.regionMatches(true, 4, str2, 0, str2.length()-1);
		System.out.println("str��str2������ͬ��" + bool);
		
		/*
		 * subString(int index)  ��index��ʼ����ȡindex֮��������ַ���,�����ַ���
		 * subString(int begin,int end) ��begin��ʼ��ȡ����end���������ظ�������ַ���
		 * */
		String temp = str.substring(26);
		//System.out.println(temp);
		
		temp = str.substring(0, 26);
		//System.out.println(temp);
		
		//replace(char old,char new)  �滻ָ�����ַ�,�����滻����µ��ַ���,ֻҪ�����滻�����������滻
		temp = str.replace(' ', '|');
		System.out.println(temp);
		
		//replaceAll() ͨ�����������ʽʹ�ã�������ʽ�����
		temp = str.replaceAll("\\s+", "|");
		System.out.println(temp);
		
		//trim()  ȥ���ַ�������Ŀո�,�����µ��ַ���
		String str3 = "   a b c  ";
		System.out.println("str3ȥ���ո��" + str3.trim());
		
		//concat(String) ƴ���ַ���,�����µ��ַ���,concat�ͺ�+ƴ�ӵ�������һ����
		String newString = str3.concat("efg");
		System.out.println("concatƴ�ӵ��ַ�����" + newString);
		
		//split(String) ����ָ�����Ż�������ʽ�ָ��ַ�����Ϊһ���ַ�������
		String param = "1|2|3|4";
		String[] split = param.split("|");
		System.out.println(Arrays.toString(split));
	}
}
