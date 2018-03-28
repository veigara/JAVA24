package com.hxzy_abstractFactory.factory;

import com.hxzy_abstractFactory.human.Human;
import com.hxzy_abstractFactory.human.HumanEnum;

/**
 * ����Ů���˵Ĺ���
 * @author Administrator
 *
 */
public class MaleFactory extends AbstractHumanFactory {

	@Override
	public Human createYellowHuman() {
		return super.createHuman(HumanEnum.YellowFemaleHuman);
	}

	@Override
	public Human createWhiteHuman() {
		return super.createHuman(HumanEnum.WhiteFemaleHuman);
	}

	@Override
	public Human createBlackHuman() {
		return super.createHuman(HumanEnum.BlackFemaleHuman);
	}

}
