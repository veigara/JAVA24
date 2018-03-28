package printer.machine;

import printer.inkbox.InkBox;
import printer.paper.Paper;

/**
 * ��ӡ����������
 * �κεĴ�ӡ���������
 * 		ֽ�ţ�ī�У�Ʒ��
 * @author Administrator
 *
 */
public abstract class Printer implements IPrinter{

	public Printer(String brand, InkBox inkBox, Paper paper) {
		super();
		this.brand = brand;
		this.inkBox = inkBox;
		this.paper = paper;
	}
	private String brand;
	
	private InkBox inkBox;//ī��
	private Paper paper;//ֽ��
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public InkBox getInkBox() {
		return inkBox;
	}
	public void setInkBox(InkBox inkBox) {
		this.inkBox = inkBox;
	}
	public Paper getPaper() {
		return paper;
	}
	public void setPaper(Paper paper) {
		this.paper = paper;
	}

}
