package com.hxzy.interfacedemo2;

/**
 * 抽象类中，抽象方法必须在子类中重写，除非子类也是抽象类
 * @author Administrator
 *
 */
public interface C extends A,B{
	public void common();
	public void c();
}
