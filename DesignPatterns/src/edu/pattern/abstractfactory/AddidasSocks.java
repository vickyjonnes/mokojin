package edu.pattern.abstractfactory;

public class AddidasSocks implements Socks {

	private Brand brand;
	public AddidasSocks() {
		this.brand=Brand.ADDIDAS;
	}
	@Override
	public Brand getSocks() {
		return this.brand;
	}

}
