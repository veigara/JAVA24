package test;

public class Test1 {

	public static void main(String[] args) {
		/*
		 * ơ��2Ԫ1ƿ,4��ƿ�ǿɻ�һƿ, 2����ƿ�ɻ�һƿ,
   			��10000Ԫ�ɺȶ���
		 * */
		int price = 10000;
		int total = price / 2;
		int empty = total; //��ƿ5000
		int gz = total; //5000
		
		while (true) {
			while (empty >= 2) {
				total += empty / 2;
				gz += empty / 2;
				empty = empty / 2 + empty % 2;
			}
			while (gz >= 4) {
				total += gz / 4;
				empty += gz / 4;
				gz = gz / 4 + gz % 4;
			}
			if (empty < 2 && gz < 4) {
				break;
			}
		}
		System.out.println("total:" + total + ",gz:" + gz + ",empty:" + empty);
	}

}
