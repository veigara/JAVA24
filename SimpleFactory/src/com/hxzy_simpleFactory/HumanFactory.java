package com.hxzy_simpleFactory;

/**
 * 工厂类
 * 负责创建不同肤色人的对象
 * @author Administrator
 *
 */
public class HumanFactory {
	public static Human createHuman(HumanEnum enums) {
		Human human = null;
		/*if (enums.BlackHuman) {
			return null;
		}*/
		
		if (enums == HumanEnum.YellowHuman) {
			human = new YellowHuman();
		} else if (enums == HumanEnum.WhiteHuman) {
			human = new WhiteHuman();
		} else if (enums == HumanEnum.BlackHuman) {
			human = new BlackHuman();
		}
		return human;
	}
}
