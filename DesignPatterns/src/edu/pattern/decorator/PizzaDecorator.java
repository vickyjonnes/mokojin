package edu.pattern.decorator;

public class PizzaDecorator implements Pizza {

	private Pizza pizza;
	public PizzaDecorator(Pizza pizza) {
		this.pizza=pizza;
	}
	
	@Override
	public String bake() {
		return pizza.bake();
	}

	@Override
	public String addTopings() {
		return pizza.addTopings();
	}

	@Override
	public int getCost() {
		return pizza.getCost();
	}

}
