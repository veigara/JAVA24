package com.hxzy;

public enum SeasonEnum {
	
	SPING("����","�������̽��ϰ�"),//����
	SUMMER("����","С�ɲ�¶����"),
	AUTUMN("����","��ˮ������һɫ"),
	WINTER("����","��������ǧ��ѩ");
	
	
	//1.˽�л���������
	private final String num1;
	private final String num2;
	//2.˽�л����캯��
	private  SeasonEnum(String num1,String num2) {
		this.num1=num1;
		this.num2=num2;
	}
	 
	public String getNum1() {
		return num1;
	}

	public String getNum2() {
		return num2;
	}

	@Override
	public String toString() {
		String num12 = SeasonEnum.valueOf(super.name()).getNum1();
		String num22 = SeasonEnum.valueOf(super.name()).getNum2();
		return "[����] : " + num1 + "\t[ʫ��] : " + num2;
	}
	
}
