package edu.pattern.adapter;

public class Volt {
	private int volt;
	public Volt(int volt) {
		this.volt=volt;
	}
	
	public int getVolt() {
		return this.volt;
	}

	@Override
	public String toString() {
		return "Volt [volt=" + volt + "]";
	}
	
	
}
