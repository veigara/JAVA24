package com.hxzy.homework;

import net.sourceforge.pinyin4j.PinyinHelper;

public class Employee implements Comparable<Employee> {

	private String name;
	
	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Employee other = (Employee) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public int compareTo(Employee o) {
		String o1 = PinYinHelper.toPinYinString(name);
		String o2 = PinYinHelper.toPinYinString(o.getName());
		return o1.compareTo(o2);
	}

}
