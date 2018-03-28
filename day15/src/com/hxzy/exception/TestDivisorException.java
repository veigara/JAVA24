package com.hxzy.exception;

public class TestDivisorException {

	public static void main(String[] args) {
		//runtime();
		
		/*
		 * try-catch-finally
		 * 尝试捕获有可能出现异常的代码块
		 * 一旦出现异常，则立即跳转到catch代码块
		 * 
		 * 组合：try-catch
		 * 		try-catch-finally
		 * 		try-finally
		 * */
		try {
			int num1 = 10,num2 = 0;
			check(num1,num2);
		} catch (DivisorException e) {
			//e.printStackTrace();//通过堆栈原理打印异常信息,这条代码不是必须要写
			System.out.println("程序出现了异常");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//无论程序是否出现异常都会执行的代码块
			System.out.println("程序结束");
		}
	}

	//1.运行时异常的演示
	private static void runtime() {
		int num1 = 10;
		int num2 = 0;
		System.out.println(num1 / num2);
	}
	
	/*
	 * throws：方法内部有可能向方法的调用者抛出一个异常。
	 * 		  因此：方法的调用者必须手动捕获throws抛出的异常
	 * throw:抛出的是异常的实例，对象
	 * */
	private static void check(int num1,int num2) throws DivisorException, ClassNotFoundException {
		//检查异常通常需要结合条件判断一起使用
		if (num2 == 0) {
			throw new DivisorException();
		}
		/*if (true) {
			throw new ClassNotFoundException();
		}*/
		System.out.println(num1 / num2);
	}
}
