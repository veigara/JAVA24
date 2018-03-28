package printer.paper;

/**
 * ж╫уе,A4   B5
 * @author Administrator
 *
 */
public abstract class Paper {

	private String size; //ж╫уеЁъ╢Г

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Paper(String size) {
		super();
		this.size = size;
	}
	
}
