package springbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DConnectionMaker implements ConnectionMaker {

	public Connection makeConnection() throws ClassNotFoundException, SQLException {
	    final String DRIVER = "com.mysql.jdbc.Driver";
	    final String URL = "jdbc:mysql://localhost:3306/sys?useSSL=false";
	    final String USER = "root";
	    final String PW = "mysql";
		Class.forName(DRIVER);
		Connection c = DriverManager.getConnection(URL, USER, PW);
		return c;
	}
}
