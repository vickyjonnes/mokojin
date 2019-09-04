package edu.pattern.prototype;

import java.util.HashMap;

public class EmployeeFactory {
	private final HashMap<String,Employee> cache=new HashMap<>();
	private EmployeeFactory() {
		cache.put("Developer", new Developer(26, "Faizan", "SSE", "BLR", 100));
		cache.put("Manager", new Manager(26, "Sumit", "ED", "BLR", 1000));
	}
	
	public static EmployeeFactory INSTANCE;
	
	static {
		if(INSTANCE==null)
			INSTANCE=new EmployeeFactory();
	}
	
	public Employee getEmployee(String type) {
		return cache.get(type).getClone();
	}
}
