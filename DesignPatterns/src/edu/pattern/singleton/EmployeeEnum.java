package edu.pattern.singleton;

/*
 * this is expected to be the best way to create singleton, because this will even safe guard and create only one object 
 * even in case of deserialization.
*/
public enum EmployeeEnum {
	INSTANCE;
	
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
