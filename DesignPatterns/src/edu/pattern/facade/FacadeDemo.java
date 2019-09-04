package edu.pattern.facade;

//https://howtodoinjava.com/design-patterns/structural/facade-design-pattern/
/*
 * Facade pattern is used to expose only abstract methods to the clients while dealing with a complex scenarios.
 * As in this example we have multiple database and clients needs to connect to different databases based on the requirement.
 * We want to client not to worry about the implementation and how system is managing multiple db connection. So client should
 * be able to call single method getConnection(DbType) for all the db connections, 
 * just client need to pass DbType for the specific db connection 
*/
public class FacadeDemo {

	public static void main(String[] args) {
		DbConnection connection=new DbConnectionImpl();
		System.out.println(connection.getConnection(DbType.ORACLE));
		System.out.println(connection.getConnection(DbType.SYBASE));
	}

}
