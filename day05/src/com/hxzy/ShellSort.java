package com.hxzy;

public class ShellSort {

	public static void main(String[] args) {
		int[] a = new int[10000000];
		for (int i = 0; i < a.length; i++) {
			//arr[i] = arr.length - 1 - i;
			a[i] = (int)(Math.random() * 10000000);
		}
		System.out.println("�����ʼ����ɣ�׼����ʼ����");
		long begin = System.currentTimeMillis();
		// ϣ������
		int d = a.length;//����
		
		while (true) {
			d = d / 2;
			for (int x = 0; x < d; x++) {
				for (int i = x + d; i < a.length; i = i + d) {
					int temp = a[i];
					int j;
					for (j = i - d; j >= 0 && a[j] > temp; j = j - d) {
						a[j + d] = a[j];
					}
					a[j + d] = temp;
				}
			}
			if (d == 1) {
				break;
			}
		}
		long end = System.currentTimeMillis();
		long time = end - begin;
		System.out.println("ʹ���۰������������10������ֺ�ʱ��" + time);
		
	}

}
