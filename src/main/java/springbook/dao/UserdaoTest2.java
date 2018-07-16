package springbook.dao;

import java.sql.SQLException;

public class UserdaoTest2 {

	public static void main(String[] args) throws SQLException {
		UserDao dao = new UserDao();
		dao.deleteAll();
	}

}
