package printer;

import printer.inkbox.BlackInkBox;
import printer.inkbox.ColorInkBox;
import printer.inkbox.InkBox;
import printer.machine.HpPrinter;
import printer.machine.Printer;
import printer.paper.A4Paper;
import printer.paper.B5Paper;
import printer.paper.Paper;

public class Client {

	public static void main(String[] args) {
		/**
		 * 安装一台惠普打印机，同时安装墨盒和纸张
		 */
		/*InkBox inkBox = new ColorInkBox();//父类类型，子类对象
		Paper paper = new A4Paper();*/
		InkBox inkBox = new BlackInkBox();//父类类型，子类对象
		Paper paper = new B5Paper();
		
		Printer printer = new HpPrinter(inkBox, paper);
		
		printer.print("hello world!");
	}
}
