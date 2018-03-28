package printer.machine;

import printer.inkbox.InkBox;
import printer.paper.Paper;

public class HpPrinter extends Printer {

	public HpPrinter(InkBox inkBox, Paper paper) {
		super("惠普", inkBox, paper);
	}

	@Override
	public void print(String content) {
		String brand = super.getBrand();
		String ink_color = super.getInkBox().getColor();//墨盒颜色
		String paper_size = super.getPaper().getSize();//尺寸
		System.out.println(brand + "打印机使用" + ink_color + "墨盒在" + paper_size + "上打印了" + content);
	}

}
