package edu.pattern.decorator;

public class BasePizza implements Pizza {

	private int cost;
	public BasePizza() {
		cost=60;
	}
	
	@Override
	public String bake() {
		return "Pizza is baked. No topings added";
	}

	@Override
	public String addTopings() {
		return "";
	}

	@Override
	public int getCost() {
		return this.cost;
	}

}
