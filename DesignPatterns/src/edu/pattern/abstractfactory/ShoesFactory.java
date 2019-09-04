package edu.pattern.abstractfactory;

public class ShoesFactory extends AbstractFactory{
	
	@Override
	public Shoes getShoes(Brand brand) {
		switch(brand) {
		case PUMA: return new PumaShoes();
		case NIKE: return new NikeShoes();
		default: return null;
		}
	}
	
	@Override
	public Socks getSocks(Brand brand) {
		return null;
	}
}
