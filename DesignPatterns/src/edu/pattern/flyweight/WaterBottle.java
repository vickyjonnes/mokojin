package edu.pattern.flyweight;

public class WaterBottle implements Bottle {

	private final Content content;
	private BottleSize size;
	
	public WaterBottle(BottleSize size) {
		content=Content.WATER;
		this.size=size;
	}

	@Override
	public Content getContent() {
		return content;
	}
	
	@Override
	public BottleSize getBottleSize() {
		return this.size;
	}

}
