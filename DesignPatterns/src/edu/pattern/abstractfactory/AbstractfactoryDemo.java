package edu.pattern.abstractfactory;

/*
 * This pattern is also called factory of factory. As the name suggest it will have factory (abstract factory) which will act
 * as a factory to create new objects everytime, of individual items factory. As in this example we have taken 2 items shoes and socks
 * both have their separate factories as shoesfactory and socksfactory. There is on FactoryOfFactory class which will create 
 * factories of each item and the factory of an item will always be new. 
*/
public class AbstractfactoryDemo {

	public static void main(String[] args) {
		Shoes shoes=FactoryOfFactory.INSTANCE.getFactory("Shoes").getShoes(Brand.NIKE);
		Socks socks=FactoryOfFactory.INSTANCE.getFactory("Socks").getSocks(Brand.ADDIDAS);
		
		System.out.println("Socks: "+socks.getSocks()+ " Shoes: "+shoes.getShoes());
	}

}
