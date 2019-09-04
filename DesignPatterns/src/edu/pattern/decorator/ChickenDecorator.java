package edu.pattern.decorator;

public class ChickenDecorator extends PizzaDecorator {

	public ChickenDecorator(Pizza pizza) {
		super(pizza);
	}
	
	@Override
	public String addTopings() {
		return super.addTopings()+" Chicken topings added.";
	}
	
	@Override
	public int getCost() {
		return super.getCost()+90;
	}

}
