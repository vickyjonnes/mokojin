package edu.pattern.abstractfactory;

public class PumaSocks implements Socks {

	private Brand brand;
	public PumaSocks() {
		this.brand=Brand.PUMA;
	}
	@Override
	public Brand getSocks() {
		return this.brand;
	}

}
