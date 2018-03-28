package com.hxzy;

public class Text {

	public static void main(String[] args) {
		
		String string = SeasonEnum.SPING.toString();
		System.out.println("------------");
		//System.out.println(string);
		SeasonEnum valueOf = SeasonEnum.valueOf("WINTER");
		String num1 = valueOf.getNum1();
		//System.out.println(num1);
		SeasonEnum[] values = SeasonEnum.values();
		for (SeasonEnum seasonEnum : values) {
			System.out.println(seasonEnum);
		}
	}

}
