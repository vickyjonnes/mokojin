package edu.pattern.factory;

public class ShoesFactory {
	public static ShoesFactory INSTANCE;
	
	private ShoesFactory() {}
	
	static {
		if(INSTANCE==null) {
			INSTANCE=new ShoesFactory();
		}
	}
	
	public Shoes getShoes(Brand brand) {
		switch(brand) {
		case PUMA: return new PumaShoes();
		case NIKE: return new NikeShoes();
		default: return null;
		}
	}
}
