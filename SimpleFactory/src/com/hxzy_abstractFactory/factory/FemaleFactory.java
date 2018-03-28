package com.hxzy_abstractFactory.factory;

import com.hxzy_abstractFactory.human.Human;
import com.hxzy_abstractFactory.human.HumanEnum;

/**
 * ���������˵Ĺ���
 * @author Administrator
 *
 */
public class FemaleFactory extends AbstractHumanFactory {

	@Override
	public Human createYellowHuman() {
		return super.createHuman(HumanEnum.YellowMaleHuman);
	}

	@Override
	public Human createWhiteHuman() {
		return super.createHuman(HumanEnum.WhiteMaleHuman);
	}

	@Override
	public Human createBlackHuman() {
		return super.createHuman(HumanEnum.BlackMaleHuman);
	}

}
