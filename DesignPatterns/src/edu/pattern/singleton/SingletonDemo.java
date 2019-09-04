package edu.pattern.singleton;

public class SingletonDemo {

	public static void main(String[] args) {
		Employee emp1=Employee.getInstance();
		Employee emp2=Employee.getInstance();
		System.out.println(emp1.equals(emp2));
		
		EmployeeEnum e1=EmployeeEnum.INSTANCE;
		EmployeeEnum e2=EmployeeEnum.INSTANCE;
		
		System.out.println(e1 == e2);
		System.out.println(e1.equals(e2));
	}

}
