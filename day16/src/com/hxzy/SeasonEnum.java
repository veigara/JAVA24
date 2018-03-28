package com.hxzy;

public enum SeasonEnum {
	
	SPING("春天","春风又绿江南岸"),//对像
	SUMMER("夏天","小荷才露尖尖角"),
	AUTUMN("秋天","秋水共长天一色"),
	WINTER("冬天","窗含西岭千秋雪");
	
	
	//1.私有化常量属性
	private final String num1;
	private final String num2;
	//2.私有化构造函数
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
		return "[季节] : " + num1 + "\t[诗歌] : " + num2;
	}
	
}
