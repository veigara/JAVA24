package test;

public class Test {
	public static void main(String[] args) {
		Sub obj = new Sub();
		obj.print();
		/*
		 * ʵ����������Ķ���
		 * ������û����дprint����
		 * ������������õ�print������δ�Ǹ����print����
		 * �������SΪ�����е�X
		 * ������д��printAgain��������˸����е���printAgainʵ���ϵ��õľ���������д�ķ���
		 * */
	}
}

class Base {
	public String s = "X";

	public void print() {
		System.out.print(s);
		printAgain();
	}

	public void printAgain() {
		System.out.print("A");
	}
}

class Sub extends Base {
	public String s = "Y";

	public void printAgain() {
		System.out.print("B");
	}
}

class Test2{
	static int func(int i, int j){
        try{
              return i/j;
        }catch(ArithmeticException e){
                 System.out.print("A");
                 return 0;
        }catch(Exception e){
                 System.out.print("B");
                 return 0;
        }finally{
                 System.out.print("C");
        }
}
public static void main(String[] args){
        System.out.println(func(1,0));
}

}
