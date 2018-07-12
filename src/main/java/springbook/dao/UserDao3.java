package springbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springbook.model.User;

public class UserDao3 {
	public Connection getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?useSSL=false", "root", "mysql");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

	public User get(Integer deptno) throws ClassNotFoundException, SQLException {
		
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(
				"select * from dept where deptno = ?");
		ps.setInt(1 , deptno);
		ResultSet rs = ps.executeQuery();
		User user = new User();
		if(rs.next()) {
			user.setDeptno(rs.getInt("deptno"));
			user.setDname(rs.getString("dname"));
			user.setLoc(rs.getString("Loc"));
		}
		rs.close();
		ps.close();
		c.close();
		return user;
	}
	public void add(User user) throws ClassNotFoundException, SQLException {
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(
				"insert into dept(deptno, dname, loc) values(?, ?, ?)");
		ps.setInt(1, user.getDeptno());
		ps.setString(2, user.getDname());
		ps.setString(3, user.getLoc());
		ps.executeUpdate();
		ps.close();
		c.close();
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		User user = new User();
		user.setDeptno(50);
		user.setDname("개발5부");
		user.setLoc("서울");
		
		UserDao3 dao = new UserDao3();
		dao.add(user);
		dao.get(10);
	}
}
