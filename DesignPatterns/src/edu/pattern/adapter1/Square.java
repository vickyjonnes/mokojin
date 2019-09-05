package edu.pattern.adapter1;

public class Square implements GenericShape {

	@Override
	public void draw() {
		System.out.println("Drawing Sqaure");
	}

	@Override
	public boolean isVisible() {
		return true;
	}

}
