package edu.pattern.decorator;

public class CheezDecorator extends PizzaDecorator {

	public CheezDecorator(Pizza pizza) {
		super(pizza);
	}
	
	@Override
	public String addTopings() {
		return super.addTopings()+"Cheez topings added.";
	}
	
	@Override
	public int getCost() {
		return super.getCost()+60;
	}

}
