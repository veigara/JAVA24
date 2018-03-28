package com.hxzy_simpleFactory;

public class NvWa {

	public static void main(String[] args) {
		/*HumanEnum[] values = HumanEnum.values();
		for (HumanEnum value : values) {
			System.out.println(value);
		}*/
		
		
		Human yellowHuman = HumanFactory.createHuman(HumanEnum.YellowHuman);
		yellowHuman.talk();
		
		Human whiteHuman = HumanFactory.createHuman(HumanEnum.WhiteHuman);
		whiteHuman.talk();
		
		Human blackHuman = HumanFactory.createHuman(HumanEnum.BlackHuman);
		blackHuman.talk();
		
	}

}
