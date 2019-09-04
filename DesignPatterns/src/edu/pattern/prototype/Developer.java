package edu.pattern.prototype;

public class Developer implements Employee {

	private int age;
	private String name;
	private String designation;
	private String address;
	private double salary;
	
	
	public Developer(int age, String name, String designation, String address, double salary) {
		super();
		this.age = age;
		this.name = name;
		this.designation = designation;
		this.address = address;
		this.salary = salary;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	@Override
	public Employee getClone() {
		Employee e=null;
		try {
			e=(Employee) super.clone();
		} catch (CloneNotSupportedException ex) {
			ex.printStackTrace();
		}
		return e;
	}

}
