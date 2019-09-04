package edu.pattern.decorator;

/*
 * Decorator design pattern is to add new functionalities to the already existing object at run time.
*/
public class DecoratorDemo {

	public static void main(String[] args) {
		Pizza pizza=new BasePizza();
		pizza=new CheezDecorator(pizza);
		System.out.println(pizza.bake());
		System.out.println(pizza.addTopings());
		System.out.println(pizza.getCost());
		
		pizza=new ChickenDecorator(pizza);
		
		System.out.println(pizza.bake());
		System.out.println(pizza.addTopings());
		System.out.println(pizza.getCost());
	}

}
