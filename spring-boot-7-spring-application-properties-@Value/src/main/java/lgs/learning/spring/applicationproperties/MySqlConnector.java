package lgs.learning.spring.applicationproperties;

public class MySqlConnector extends DatabaseConnector {
	@Override
	public void connect() {
		System.out.println("Đã kết nối tới Mysql: " + getUrl());
	}
}
