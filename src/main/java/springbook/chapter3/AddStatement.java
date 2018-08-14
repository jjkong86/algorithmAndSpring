package springbook.chapter3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import springbook.model.User;

public class AddStatement implements StatementStrategy {
	User user;
	
	public AddStatement(User user) {
		this.user = user;
	}
	
	@Override
	public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
		
		PreparedStatement ps = c.prepareStatement(
				"insert into dept(deptno, dname, loc) values(?, ?, ?)");
		ps.setInt(1, user.getDeptno());
		ps.setString(2, user.getDname());
		ps.setString(3, user.getLoc());
		return ps;
	}

}
