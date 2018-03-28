package printer.machine;

import printer.inkbox.InkBox;
import printer.paper.Paper;

/**
 * 打印机，抽象类
 * 任何的打印机必须包含
 * 		纸张，墨盒，品牌
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
	
	private InkBox inkBox;//墨盒
	private Paper paper;//纸张
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
