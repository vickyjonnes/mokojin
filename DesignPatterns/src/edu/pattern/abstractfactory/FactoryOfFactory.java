package edu.pattern.abstractfactory;

public class FactoryOfFactory {
	public static FactoryOfFactory INSTANCE;
	
	private FactoryOfFactory() {} 
	static {
		if(INSTANCE==null)
			INSTANCE=new FactoryOfFactory();
	}
	
	public AbstractFactory getFactory(String factoryName) {
		if(factoryName.equals("Socks")) {
			return new SocksFactory();
		}else if(factoryName.equals("Shoes")) {
			return new ShoesFactory();
		}else {
			return null;
		}
	}
}
