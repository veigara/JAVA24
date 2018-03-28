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
		 * ��װһ̨���մ�ӡ����ͬʱ��װī�к�ֽ��
		 */
		/*InkBox inkBox = new ColorInkBox();//�������ͣ��������
		Paper paper = new A4Paper();*/
		InkBox inkBox = new BlackInkBox();//�������ͣ��������
		Paper paper = new B5Paper();
		
		Printer printer = new HpPrinter(inkBox, paper);
		
		printer.print("hello world!");
	}
}
