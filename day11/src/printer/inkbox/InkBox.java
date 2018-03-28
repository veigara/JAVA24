package printer.inkbox;

public abstract class InkBox {
	
	public InkBox(String color) {
		super();
		this.color = color;
	}

	private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
