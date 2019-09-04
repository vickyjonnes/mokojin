package edu.pattern.proxy;

public class ProxyInternetAccess implements InternetAccess {

	private String username;
	private RealInternetAccess access;
	public ProxyInternetAccess(String username) {
		this.username=username;
	}
	
	
	@Override
	public String getAccess() {
		if(isAllowed(this.username)) {
			access=new RealInternetAccess(username);
			return access.getAccess();
		}
		return "User is not authorised";
	}
	
	private boolean isAllowed(String username) {
		if(Role.ADMIN.name().equals(username) || Role.USER.name().equals(username))
			return true;
		else
			return false;
	}

}
