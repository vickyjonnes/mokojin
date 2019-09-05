package edu.pattern.adapter1;

public class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Drawing Rectangle");
	}

	@Override
	public String getName() {
		return "Rectangle";
	}

}
