package lgs.learning.spring.configurationbean;

public class PostgreSqlConnector extends DatabaseConnector {
	@Override
	public void connect() {
		System.out.println("Đã kết nối tới Postgresql: " + getUrl());
	}
}
