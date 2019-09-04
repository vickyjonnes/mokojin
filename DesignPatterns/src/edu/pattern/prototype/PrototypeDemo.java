package edu.pattern.prototype;

/*
 * This pattern reduce the effort of creating an object in case there are many fields in the class and all are manadatory.
 * This pattern create load the cache at the start and then return the clone of the same object everytime. 
 * The is different then flyweight in 2 ways. 1: It create all the objects at start while flywight creat object and store them in 
 * cache at run time. 2: This create a new object everytime while flywight return the same object (same hashcode), as we see in 
 * this class.
*/
public class PrototypeDemo {

	public static void main(String[] args) {
		Employee dev1=EmployeeFactory.INSTANCE.getEmployee("Developer");
		Employee dev2=EmployeeFactory.INSTANCE.getEmployee("Developer");
		
		System.out.println(dev1.hashCode()+"\n"+dev2.hashCode());
		System.out.println(dev1.equals(dev2));
	}

}
