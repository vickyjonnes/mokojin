package edu.pattern.adapter1;

public class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("Drawing circle");
	}

	@Override
	public String getName() {
		return "Circle";
	}

}
