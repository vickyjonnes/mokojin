package edu.pattern.proxy;

/*
 * this pattern is adding a layer to the actual interface. Like of authentication/authorisation in this case.
*/
public class ProxyDemo {

	public static void main(String[] args) {
		InternetAccess access=new ProxyInternetAccess("USER");
		System.out.println(access.getAccess());
		access=new ProxyInternetAccess("Hello");
		System.out.println(access.getAccess());
	}

}
