package edu.pattern.facade;

public interface DbConnection {
	public String getConnection(DbType type);
}
