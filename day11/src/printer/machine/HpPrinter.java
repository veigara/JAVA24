package printer.machine;

import printer.inkbox.InkBox;
import printer.paper.Paper;

public class HpPrinter extends Printer {

	public HpPrinter(InkBox inkBox, Paper paper) {
		super("����", inkBox, paper);
	}

	@Override
	public void print(String content) {
		String brand = super.getBrand();
		String ink_color = super.getInkBox().getColor();//ī����ɫ
		String paper_size = super.getPaper().getSize();//�ߴ�
		System.out.println(brand + "��ӡ��ʹ��" + ink_color + "ī����" + paper_size + "�ϴ�ӡ��" + content);
	}

}
