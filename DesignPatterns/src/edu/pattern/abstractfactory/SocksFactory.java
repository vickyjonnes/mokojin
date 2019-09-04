package edu.pattern.abstractfactory;

public class SocksFactory extends AbstractFactory{

	@Override
	public Socks getSocks(Brand brand) {
		switch(brand) {
		case PUMA: return new PumaSocks();
		case ADDIDAS: return new AddidasSocks();
		default: return null;
		}
	}
	
	@Override
	public Shoes getShoes(Brand brand) {
		return null;
	}
}
