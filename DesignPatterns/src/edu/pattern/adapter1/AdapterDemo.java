package edu.pattern.adapter1;

/*
 * There are multiple ways to implement adapter pattern. In this example we have used object adapter pattern. First we had 2 interfaces
 * shape and generic shape, their individual impl classes. We had a client draing which is only able to use shape not generic shape
 * so to make client to be able to used generic shape as well we have written GenericShapeAdpater. There are other ways to achieve
 * this as well. ClassAdpater pattern, Two ways adapter pattern. https://dzone.com/articles/adapter-design-pattern-in-java
*/
public class AdapterDemo {

	public static void main(String[] args) {
		DrawingClient client=new DrawingClient();
		client.drawShape(new Circle());
		System.out.println(client.getNameOfShape(new Rectangle()));
		
		client.drawShape(new GenericShapeAdapter(new Square()));
	}

}
