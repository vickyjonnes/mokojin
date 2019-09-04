package edu.pattern.flyweight;

public class MilkBottle implements Bottle {
	
	private final Content content;
	private BottleSize size;
	
	public MilkBottle(BottleSize size) {
		content=Content.MILK;
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
