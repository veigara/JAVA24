package com.hxzy;

public class Demo_1 {

	public static void main(String[] args) {
		double[] scores = {89,76,98,55,81};
		double sum = 0;
		/*��ƽ����*/
		/*
		sum += scores[0];
		sum += scores[1];
		sum += scores[2];
		sum += scores[3];
		sum += scores[4];
		*/
		for (int i = 0; i < scores.length; i++) {
			sum += scores[i];
		}
		System.out.println("������" + sum + ",ƽ����" + sum/5);
	}

}
