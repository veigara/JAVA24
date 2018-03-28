package com.hxzy.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class Test {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(StudentBizImplTest.class);
	      for (Failure failure : result.getFailures()) {
	         System.err.println(failure.toString()); //û��ͨ�����Ե���Ϣ
	      }
	      System.out.println(result.wasSuccessful());//�Ƿ�ȫ��ͨ������
	}

}
