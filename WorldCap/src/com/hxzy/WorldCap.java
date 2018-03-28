package com.hxzy;

public class WorldCap {
	private String js;
	private Integer year;
	private String locate;
	private String winner;
	public String getJs() {
		return js;
	}
	public void setJs(String js) {
		this.js = js;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getLocate() {
		return locate;
	}
	public void setLocate(String locate) {
		this.locate = locate;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((js == null) ? 0 : js.hashCode());
		result = prime * result + ((locate == null) ? 0 : locate.hashCode());
		result = prime * result + ((winner == null) ? 0 : winner.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorldCap other = (WorldCap) obj;
		if (js == null) {
			if (other.js != null)
				return false;
		} else if (!js.equals(other.js))
			return false;
		if (locate == null) {
			if (other.locate != null)
				return false;
		} else if (!locate.equals(other.locate))
			return false;
		if (winner == null) {
			if (other.winner != null)
				return false;
		} else if (!winner.equals(other.winner))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}
	public WorldCap(String js, Integer year, String locate, String winner) {
		super();
		this.js = js;
		this.year = year;
		this.locate = locate;
		this.winner = winner;
	}
	public WorldCap() {
		super();
	}
	@Override
	public String toString() {
		return "WorldCap [js=" + js + ", year=" + year + ", locate=" + locate + ", winner=" + winner + "]";
	}
	
}	
