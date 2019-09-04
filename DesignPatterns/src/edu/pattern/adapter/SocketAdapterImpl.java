package edu.pattern.adapter;

public class SocketAdapterImpl implements SocketAdapter {

	private Socket socket;
	public SocketAdapterImpl(Socket socket) {
		this.socket=socket;
	}
	
	@Override
	public Volt get120Volt() {
		return socket.getVolt();
	}

	@Override
	public Volt get12Volt() {
		return convert(socket.getVolt(), 10);
	}

	@Override
	public Volt get3Volt() {
		return convert(socket.getVolt(),40);
	}
	
	private Volt convert(Volt v, int div) {
		return new Volt(v.getVolt()/div);
	}

}
