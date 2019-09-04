package edu.pattern.singleton;

/*
 * this is a double check locking, to safe guard and create only one instance even in multi-threaded environment.
*/
public class Employee {
	private String name;
	private int age;
	
	private Employee() {}
	
	private static volatile Employee emp;
	
	public static synchronized Employee getInstance() {
		if(emp==null)
			synchronized (Employee.class) {
				emp=new Employee();
			}
		return emp;

	}

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
