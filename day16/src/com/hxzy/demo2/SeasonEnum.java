package com.hxzy.demo2;

public enum SeasonEnum {
	
	/*
	 * ����ö���еĹ��캯��
	 * SPRING,SUMMER,AUTUMN,WINTER��Ϊö�ٵĳ�����
	 * */
	SPRING("����","�������̽��ϰ�",1),//ö�ٶ���
	SUMMER("����","ӳ�պɻ�������",2),//ö�ٶ���
	AUTUMN("����","��ˮ������һɫ",3),//ö�ٶ���
	WINTER("����","��������ǧ��ѩ",4);//ö�ٶ���
	
	/*ö���е����Զ�Ӧ����˽�еĳ���*/
	private final String value1;
	private final String value2;
	private final int count;
	
	/**
	 * ö���еĹ��캯��������˽�л�
	 * @param value1
	 * @param value2
	 */
	private SeasonEnum(String value1, String value2,int count) {
		this.value1 = value1;
		this.value2 = value2;
		this.count = count;
	}

	public String getValue1() {
		return value1;
	}

	public String getValue2() {
		return value2;
	}

	public int getCount() {
		return count;
	}

	@Override
	public String toString() {
		//super.name() ��ȡ���ǵ���ö�ٵĳ�����   SeasonEnum.WINTER.toString()
		String value1 = SeasonEnum.valueOf(super.name()).getValue1();
		String value2 = SeasonEnum.valueOf(super.name()).getValue2();
		return "[value1] = " + value1 + ",[value2] = " + value2;
	}
	
}
