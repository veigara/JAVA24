package printer.paper;

/**
 * ֽ��,A4   B5
 * @author Administrator
 *
 */
public abstract class Paper {

	private String size; //ֽ�ųߴ�

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
