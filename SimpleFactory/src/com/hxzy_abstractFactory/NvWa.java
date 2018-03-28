package com.hxzy_abstractFactory;

import com.hxzy_abstractFactory.factory.AbstractHumanFactory;
import com.hxzy_abstractFactory.factory.FemaleFactory;
import com.hxzy_abstractFactory.factory.MaleFactory;
import com.hxzy_abstractFactory.human.Human;

public class NvWa {

	public static void main(String[] args) {
		//���󹤳�
		AbstractHumanFactory f1 = new FemaleFactory(); 
		AbstractHumanFactory f2 = new MaleFactory(); 
		
		Human h1 = f1.createYellowHuman();//Ů�Թ���
		h1.talk();
		h1.sex();
		
		Human h2 = f2.createYellowHuman();//���Թ���
		h2.talk();
		h2.sex();
	}

}
