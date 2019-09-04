package edu.pattern.builder;

public class Employee {
	private int age;
	private String name;
	private String companyName;
	
	public Employee(EmployeeBuilder builder) {
		this.age=builder.age;
		this.name=builder.name;
		this.companyName=builder.companyName;
	}
	
	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public String getCompanyName() {
		return companyName;
	}

	public static class EmployeeBuilder{
		private int age;
		private final String name;
		private String companyName;
		
		public EmployeeBuilder(String name) {
			this.name=name;
		}
		
		public EmployeeBuilder withAge(int age) {
			this.age=age;
			return this;
		}
		
		public EmployeeBuilder withCompanyName(String companyName) {
			this.companyName=companyName;
			return this;
		}
		
		public Employee build() {
			Employee emp=new Employee(this);
			return emp;
		}
	}
}
