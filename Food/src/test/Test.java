package test;

public class Test {
	public static void main(String[] args) {
		Sub obj = new Sub();
		obj.print();
		/*
		 * 实例的是子类的对象
		 * 而子类没有重写print方法
		 * 因此子类对象调用的print方法仍未是父类的print方法
		 * 父类输出S为父类中的X
		 * 子类重写了printAgain方法，因此父类中调用printAgain实际上调用的就是子类重写的方法
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
