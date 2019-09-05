package edu.pattern.adapter1;

import java.sql.SQLInvalidAuthorizationSpecException;

public class GenericShapeAdapter implements Shape {

	private GenericShape shape;
	
	public GenericShapeAdapter(GenericShape shape) {
		this.shape=shape;
	}
	
	@Override
	public void draw() {
		shape.draw();
	}

	@Override
	public String getName() {
		if(shape instanceof Square) {
			return "Square";
		}else if(shape instanceof Triangle) {
			return "Trainagle";
		}
		return "Dont have a name";
	}

}
