package com.hxzy.demo2;

public class Test {

	public static void main(String[] args) {
		//��õ�����
		SeasonEnum spring = SeasonEnum.SPRING;
		String value1 = spring.getValue1();
		String value2 = spring.getValue2();
		System.out.println(value1 + "\t" + value2);
		
		/*����ö��*/
		SeasonEnum[] values = SeasonEnum.values();//��ȡ���еļ� SPRING  SUMMER AUTUN WINTER
		for (SeasonEnum seasonEnum : values) {
			System.out.println(seasonEnum);
		}
		
		System.out.println();
		SeasonEnum s = SeasonEnum.valueOf("WINTER");
		System.out.println(s.getValue1());
		System.out.println(s.getValue2());
		System.out.println(s.getCount());
		
		System.out.println();
		System.out.println(SeasonEnum.WINTER.toString());
	}

}
