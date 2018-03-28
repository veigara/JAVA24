package com.hxzy.demo2;

public enum SeasonEnum {
	
	/*
	 * 调用枚举中的构造函数
	 * SPRING,SUMMER,AUTUMN,WINTER称为枚举的常量名
	 * */
	SPRING("春天","春风又绿江南岸",1),//枚举对象
	SUMMER("夏天","映日荷花别样红",2),//枚举对象
	AUTUMN("秋天","秋水共长天一色",3),//枚举对象
	WINTER("冬天","窗含西岭千秋雪",4);//枚举对象
	
	/*枚举中的属性都应该是私有的常量*/
	private final String value1;
	private final String value2;
	private final int count;
	
	/**
	 * 枚举中的构造函数必须是私有化
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
		//super.name() 获取的是调用枚举的常量名   SeasonEnum.WINTER.toString()
		String value1 = SeasonEnum.valueOf(super.name()).getValue1();
		String value2 = SeasonEnum.valueOf(super.name()).getValue2();
		return "[value1] = " + value1 + ",[value2] = " + value2;
	}
	
}
