package edu.pattern.flyweight;

import java.util.HashMap;

public class BottleFactory {
	private final HashMap<BottleSize, Bottle> bottleCache=new HashMap<>();
	public static BottleFactory INSTANCE;
	
	static {
		if(INSTANCE==null)
			INSTANCE=new BottleFactory();
	}
	
	public Bottle getWaterBottle(BottleSize size) {
		Bottle water=bottleCache.computeIfAbsent(size, newSize->{
			Bottle w=new WaterBottle(newSize);
			return w;
		});
		
		return water;
	}
	
	public Bottle getMilkBottle(BottleSize size) {
		Bottle milk=bottleCache.computeIfAbsent(size, newSize->{
			Bottle m=new MilkBottle(newSize);
			return m;
		});
		
		return milk;
	}
	
	public Bottle getOilBottle(BottleSize size) {
		Bottle oil=bottleCache.computeIfAbsent(size, newSize->{
			Bottle o=new OilBottle(newSize);
			return o;
		});
		
		return oil;
	}
}
