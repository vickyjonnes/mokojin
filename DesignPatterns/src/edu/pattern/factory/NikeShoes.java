package edu.pattern.factory;

public class NikeShoes implements Shoes {

	private Brand brandName;
	public NikeShoes() {
		this.brandName=Brand.NIKE;
	}
	
	@Override
	public Brand getBrandName() {
		return this.brandName;
	}

}
