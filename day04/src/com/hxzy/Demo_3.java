package com.hxzy;

/**
 * �����������ֵ
 * @author Administrator
 *
 */
public class Demo_3 {

	public static void main(String[] args) {
		int[] arr = {8,4,2,1,23,344,12};
		//����һ��������Ĭ����Ϊ����ֵ���
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		System.out.println("���ֵ" + max);
	}
}
