package com.hxzy_abstractFactory;

import com.hxzy_abstractFactory.factory.AbstractHumanFactory;
import com.hxzy_abstractFactory.factory.FemaleFactory;
import com.hxzy_abstractFactory.factory.MaleFactory;
import com.hxzy_abstractFactory.human.Human;

public class NvWa {

	public static void main(String[] args) {
		//抽象工厂
		AbstractHumanFactory f1 = new FemaleFactory(); 
		AbstractHumanFactory f2 = new MaleFactory(); 
		
		Human h1 = f1.createYellowHuman();//女性工厂
		h1.talk();
		h1.sex();
		
		Human h2 = f2.createYellowHuman();//男性工厂
		h2.talk();
		h2.sex();
	}

}
