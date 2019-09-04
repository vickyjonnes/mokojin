package edu.pattern.flyweight;

/*
 * Flyweight is to reduce memory. In this pattern we leverage the concept of cache, where all the new objects are stored
 * and returned if a client try to create a new object with the same state. String.class is implemented internally using this pattern
 * This is mainly used when u have something intrinsic (composite to the class) and something extrinsic (client will provide this)
 * in a class. As in this example, Bottle Content is intrinsic (Water, Oil, Milk) and BottleSize is extrinsic (5Ltr, 2Ltr, 1Ltr)
 * 
 * We checked in this client class that waterBottle1 and waterBottle2 are different objects but waterBottle2 and 3 are same objects.
*/
public class FlyweightDemo {

	public static void main(String[] args) {
		Bottle waterBottle1=BottleFactory.INSTANCE.getWaterBottle(BottleSize.FiveLtr);
		Bottle waterBottle2=BottleFactory.INSTANCE.getWaterBottle(BottleSize.TwoLtr);
		System.out.println(waterBottle1.equals(waterBottle2));
		System.out.println(waterBottle1.hashCode()+"\n"+waterBottle2.hashCode());
		Bottle waterBottle3=BottleFactory.INSTANCE.getWaterBottle(BottleSize.TwoLtr);
		System.out.println(waterBottle2.equals(waterBottle3));
		System.out.println(waterBottle2.hashCode()+"\n"+waterBottle3.hashCode());
	}

}
