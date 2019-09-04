package edu.pattern.abstractfactory;

public abstract class AbstractFactory {
	public abstract Shoes getShoes(Brand brand);
	public abstract Socks getSocks(Brand brand);
}
