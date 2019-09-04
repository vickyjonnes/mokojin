package edu.pattern.builder;

/*
 * Builder pattern is used to build object of immutable classes. 
*/
public class BuilderDemo {

	public static void main(String[] args) {
		Employee emp=new Employee.EmployeeBuilder("Faizan").withAge(26).withCompanyName("accolite").build();
		System.out.println(emp.getCompanyName());
	}

}
