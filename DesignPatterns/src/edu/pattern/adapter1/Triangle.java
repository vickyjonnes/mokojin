package edu.pattern.adapter1;

public class Triangle implements GenericShape {

	@Override
	public void draw() {
		System.out.println("Drawing Triangle");
	}

	@Override
	public boolean isVisible() {
		return true;
	}



}
