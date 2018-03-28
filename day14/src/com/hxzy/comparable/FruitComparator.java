package com.hxzy.comparable;

import java.util.Comparator;

/**
 * �Ƚ���
 * ����ˮ���۸���бȽ�����
 * 
 * * �����ǰ����ȱȽϵĶ���С���򷵻�-1
 * �����ǰ����ͱȽϵĶ�����ͬ���򷵻�0
 * �����ǰ����ȱȽϵĶ�����򷵻�1
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
