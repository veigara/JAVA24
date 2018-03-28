package com.hxzy_abstractFactory.factory;

import com.hxzy_abstractFactory.human.BlackFemaleHuman;
import com.hxzy_abstractFactory.human.BlackMaleHuman;
import com.hxzy_abstractFactory.human.Human;
import com.hxzy_abstractFactory.human.HumanEnum;
import com.hxzy_abstractFactory.human.WhiteFemaleHuman;
import com.hxzy_abstractFactory.human.WhiteMaleHuman;
import com.hxzy_abstractFactory.human.YellowFemaleHuman;
import com.hxzy_abstractFactory.human.YellowMaleHuman;

public abstract class AbstractHumanFactory implements HumanFactory{

	protected Human createHuman(HumanEnum humanEnum) {
		Human human = null;
		
		if (humanEnum == HumanEnum.YellowFemaleHuman) {
			human = new YellowFemaleHuman();
		} else if (humanEnum == HumanEnum.YellowMaleHuman) {
			human = new YellowMaleHuman();
		} else if (humanEnum == HumanEnum.WhiteFemaleHuman) {
			human = new WhiteFemaleHuman();
		} else if (humanEnum == HumanEnum.WhiteMaleHuman) {
			human = new WhiteMaleHuman();
		}  else if (humanEnum == HumanEnum.BlackFemaleHuman) {
			human = new BlackFemaleHuman();
		} else if (humanEnum == HumanEnum.BlackMaleHuman) {
			human = new BlackMaleHuman();
		} 
		return human;
	}
}
