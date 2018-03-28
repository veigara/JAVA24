package com.hxzy;

public class Test10 {

	public static void main(String[] args) {
		for (int i = 65; i < 69; i++) {
			char item1 = (char)i;//A
			for (int j = 65; j < 69; j++) {
				char item2 = (char)j;//A
				for (int k = 65; k < 69; k++) {
					char item3 = (char)k;//A
					//AAA,AAB,AAC,AAD
					//ABA,ABB,ABC,ABD
					String str = "" + item1 + item2 + item3;
					System.out.print(str + "\t");
				}
				System.out.println();
			}
		}
	}

}
