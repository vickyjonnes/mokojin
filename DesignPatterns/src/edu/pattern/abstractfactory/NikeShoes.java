package edu.pattern.abstractfactory;

public class NikeShoes implements Shoes {

	private Brand brandName;
	public NikeShoes() {
		this.brandName=Brand.NIKE;
	}
	
	@Override
	public Brand getShoes() {
		return this.brandName;
	}

}
