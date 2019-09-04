package edu.pattern.proxy;

public class RealInternetAccess implements InternetAccess {

	private String username;
	public RealInternetAccess(String username) {
		this.username=username;
	}
	
	@Override
	public String getAccess() {
		return "Internet Access provided to user "+username;
	}

}
