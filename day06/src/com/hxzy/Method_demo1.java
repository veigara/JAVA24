package com.hxzy;

public class Method_demo1 {

	/**
	 * �޲������޷���ֵ�ķ���
	 * void:��
	 * ������a1�ķ����Ժ󣬲������κζ���
	 */
	public void a1() {
		/*�����void�ķ���ִ��һ��ͽ���*/
		if (true) {
			return;
		}
	}
	
	/**
	 * �в������޷���ֵ�ķ���
	 * @param num һ������
	 */
	public void a2(int num) {
		
	}
	/**
	 * �з���ֵ���޲����ķ���
	 * ����������a3�����󣬿��Եõ�һ��int���͵�ֵ
	 * @return �õ�һ������
	 */
	public int a3() {
		
		return 0;
	}
	
	public String a4(int num1,int num2) {
		if (num1 > num2) {
			return "hello java oop";
		}
		return null;
	}
	
	/**
	 * �в������з���ֵ�ķ���
	 * @param num1
	 * @param str1
	 * @param c
	 * @return
	 */
	public int[] a5(int num1,String str1,char c) {
		int[] arr = {1,2,3};
		return arr;
	}
}
