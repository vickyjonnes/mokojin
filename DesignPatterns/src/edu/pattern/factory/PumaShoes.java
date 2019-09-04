package edu.pattern.factory;

public class PumaShoes implements Shoes{

	private Brand brandName;
	
	public PumaShoes() {
		this.brandName=Brand.PUMA;
	}
	
	@Override
	public Brand getBrandName() {
		return this.brandName;
	}
	
}
