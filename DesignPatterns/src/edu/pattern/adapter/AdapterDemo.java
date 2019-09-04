package edu.pattern.adapter;

/*
 * This is to make 2 separate interfaces work together for the same client.
*/
public class AdapterDemo {

	public static void main(String[] args) {
		Socket socket=new Socket();
		SocketAdapter adapter=new SocketAdapterImpl(socket);
		System.out.println(adapter.get12Volt());
	}

}
