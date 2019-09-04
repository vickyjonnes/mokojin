package edu.pattern.abstractfactory;

public class PumaShoes implements Shoes{

	private Brand brandName;
	
	public PumaShoes() {
		this.brandName=Brand.PUMA;
	}
	
	@Override
	public Brand getShoes() {
		return this.brandName;
	}
	
}
