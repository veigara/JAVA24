package com.hxzy.exception;

public class TestDivisorException {

	public static void main(String[] args) {
		//runtime();
		
		/*
		 * try-catch-finally
		 * ���Բ����п��ܳ����쳣�Ĵ����
		 * һ�������쳣����������ת��catch�����
		 * 
		 * ��ϣ�try-catch
		 * 		try-catch-finally
		 * 		try-finally
		 * */
		try {
			int num1 = 10,num2 = 0;
			check(num1,num2);
		} catch (DivisorException e) {
			//e.printStackTrace();//ͨ����ջԭ���ӡ�쳣��Ϣ,�������벻�Ǳ���Ҫд
			System.out.println("����������쳣");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//���۳����Ƿ�����쳣����ִ�еĴ����
			System.out.println("�������");
		}
	}

	//1.����ʱ�쳣����ʾ
	private static void runtime() {
		int num1 = 10;
		int num2 = 0;
		System.out.println(num1 / num2);
	}
	
	/*
	 * throws�������ڲ��п����򷽷��ĵ������׳�һ���쳣��
	 * 		  ��ˣ������ĵ����߱����ֶ�����throws�׳����쳣
	 * throw:�׳������쳣��ʵ��������
	 * */
	private static void check(int num1,int num2) throws DivisorException, ClassNotFoundException {
		//����쳣ͨ����Ҫ��������ж�һ��ʹ��
		if (num2 == 0) {
			throw new DivisorException();
		}
		/*if (true) {
			throw new ClassNotFoundException();
		}*/
		System.out.println(num1 / num2);
	}
}
