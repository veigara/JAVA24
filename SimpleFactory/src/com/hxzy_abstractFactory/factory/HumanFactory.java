package com.hxzy_abstractFactory.factory;

import com.hxzy_abstractFactory.human.Human;

public interface HumanFactory {
	public Human createYellowHuman();
	public Human createWhiteHuman();
	public Human createBlackHuman();
	
}
