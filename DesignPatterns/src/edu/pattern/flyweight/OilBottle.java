package edu.pattern.flyweight;

public class OilBottle implements Bottle {
	private final Content content;
	private BottleSize size;
	
	public OilBottle(BottleSize size) {
		content=Content.OIL;
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
