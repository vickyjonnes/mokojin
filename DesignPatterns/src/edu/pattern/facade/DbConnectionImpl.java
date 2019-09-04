package edu.pattern.facade;

public class DbConnectionImpl implements DbConnection{
	
	public String getConnection(DbType type) {
		String connectionString="";
		switch(type) {
			case ORACLE:
				connectionString="oracle db connected";
				break;
			case DB2:
				connectionString="Db2 db connected";
				break;
			case SYBASE:
				connectionString="Sybase connected";
				break;
			case MYSQL:
				connectionString="mysql connected";
				break;
			default:
				System.out.println("no db configured like this");
		}
		return connectionString;
	}
}
