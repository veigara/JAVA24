package com.hxzy;

import java.util.Arrays;

/**
 * ���ַ����۰��㷨
 * 
 * @author Administrator
 *
 */
public class Dichotomy {
	public static void main(String[] args) {
		/*
		 * �鿴�»��ֵ� ����
		 * 
		 * ������һ��100��ĳ��ȵ����飬Ҫ������������в���859998������ 1.ʹ�ö��ַ���ǰ�ᣬ���뱣֤������������� 2.���м���
		 * ���������859998��50��Ƚ� Ӧ���ڣ�50+100��/2 ��75��Ϊ�м���
		 * 
		 * (75 + 100 ) / 2 �м���Ϊ87�� ��87���859998�Ƚ�
		 * 
		 * (75 + 87) / 2 �м���81�� 81��859998�Ƚ� (81 + 87) / 84 (84 + 87) / 2 85.5 (85.5+87)
		 * / 2 86.25 (86.25 + 85.5) / 2
		 */

		int[] arr = { 998, 765, 888, 456, 321, 1, 59, 65, 159, 753 };

		Arrays.sort(arr);// ʹ��Arrays���sort������������
		//System.out.println(Arrays.toString(arr));
		// �������������������в���321�����
		int num = 888;
		
		int start = 0;//��ʼλ��
		int end = arr.length - 1; //����Ϊֹ
		while (start <= end) {
			int middle = (start + end) / 2; //ȷ���м������±�
			if (num < arr[middle]) { //������ҵ�num���м���ҪС�����ȷ��num���м���֮ǰ��ǰ�벿�֣�
				end = middle - 1;
			} else if (num > arr[middle]) {
				start = middle + 1;
			} else {
				System.out.println(middle);
				break;
			}
		}
	}
}
