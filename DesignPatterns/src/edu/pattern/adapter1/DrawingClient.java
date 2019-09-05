package edu.pattern.adapter1;

public class DrawingClient {
	
	public void drawShape(Shape shape) {
		shape.draw();
	}
	
	public String getNameOfShape(Shape shape) {
		return shape.getName();
	}
}
