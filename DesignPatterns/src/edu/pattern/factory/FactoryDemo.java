package edu.pattern.factory;

/*
 * factory pattern is to create new object everytime client ask for an object. As in this example we createed
 * a shoe factory, which will provide new everytime of the said brand. As we can see in this class, Client asked for Nike
 * shoes 2 times and it reaturs the 2 different object. shoes1.equals(shoes2) => False.
*/
public class FactoryDemo {

	public static void main(String[] args) {
		Shoes shoes1=ShoesFactory.INSTANCE.getShoes(Brand.NIKE);
		System.out.println(shoes1.getBrandName());
		Shoes shoes2=ShoesFactory.INSTANCE.getShoes(Brand.NIKE);
		System.out.println(shoes2.getBrandName());
		System.out.println(shoes1.equals(shoes2));
	}

}
