package springbook.chapter6;

import java.sql.SQLException;

import springbook.model.User;

public interface UserService {
	void add(User user);
	void upgradeLevels() throws SQLException;
}
