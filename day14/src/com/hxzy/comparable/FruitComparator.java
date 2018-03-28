package com.hxzy.comparable;

import java.util.Comparator;

/**
 * 比较器
 * 根据水果价格进行比较排序
 * 
 * * 如果当前对象比比较的对象小，则返回-1
 * 如果当前对象和比较的对象相同，则返回0
 * 如果当前对象比比较的对象大，则返回1
 * @author Administrator
 *
 */
public class FruitComparator implements Comparator<Fruit> {

	@Override
	public int compare(Fruit o1, Fruit o2) {
		if (o1.equals(o2)) {
			return 0;
		}
		return o1.getPrice() < o2.getPrice() ? -1 : (o1.getPrice() == o2.getPrice() ? 0 : 1);
	}

}
