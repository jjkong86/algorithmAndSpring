package springbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;

import springbook.model.User;

public class UserDao {
	
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public User get(Integer deptno) throws ClassNotFoundException, SQLException {
		Connection c = dataSource.getConnection();
		PreparedStatement ps = c.prepareStatement(
				"select * from dept where deptno = ?");
		ps.setInt(1 , deptno);
		ResultSet rs = ps.executeQuery();
		User user = null;
		if(rs.next()) {
			user = new User();
			user.setDeptno(rs.getInt("deptno"));
			user.setDname(rs.getString("dname"));
			user.setLoc(rs.getString("Loc"));
		}
		rs.close();
		ps.close();
		c.close();
		
		if (user == null) throw new EmptyResultDataAccessException(1);
		
		
		return user;
	}
	
	public void add(User user) throws ClassNotFoundException, SQLException {
		Connection c = dataSource.getConnection();
		PreparedStatement ps = c.prepareStatement(
				"insert into dept(deptno, dname, loc) values(?, ?, ?)");
		ps.setInt(1, user.getDeptno());
		ps.setString(2, user.getDname());
		ps.setString(3, user.getLoc());
		ps.executeUpdate();
		ps.close();
		c.close();
	}
		
	public ArrayList<Object> list() throws ClassNotFoundException, SQLException {
		Connection c = dataSource.getConnection();
		PreparedStatement ps = c.prepareStatement(
				"select * from dept");
		ResultSet rs = ps.executeQuery();
		ArrayList<Object> list = new ArrayList<Object>();
		while (rs.next()) {
			LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
			map.put("deptno", rs.getInt("deptno"));
			map.put("dname", rs.getString("dname"));
			map.put("loc", rs.getString("loc"));
			list.add(map);
		}
		rs.close();
		ps.close();
		c.close();
		return list;
		
		
	}
	
	public ArrayList<LinkedHashMap<String,Object>> convertResultSetToArrayList() throws SQLException, ClassNotFoundException {
		Connection c = dataSource.getConnection();
		PreparedStatement ps = c.prepareStatement(
				"select * from dept");
		ResultSet rs = ps.executeQuery();
	    ResultSetMetaData md = rs.getMetaData();
	    int columns = md.getColumnCount();
	    ArrayList<LinkedHashMap<String,Object>> list = new ArrayList<LinkedHashMap<String,Object>>();
	 
	    while(rs.next()) {
	    	LinkedHashMap<String,Object> row = new LinkedHashMap<String, Object>(columns);
	        for(int i=1; i<=columns; ++i) {
	            row.put(md.getColumnName(i), rs.getObject(i));
	        }
	        list.add(row);
	    }
	 
	    return list;
	}
	
	public void deleteAll() throws SQLException{
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = dataSource.getConnection();
			ps = c.prepareStatement(
					"delete from dept");	
			ps.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
			if(c != null) {
				try {
					c.close();
				} catch (SQLException e) {
				}
			}
		}
	}
	public int getCount() throws SQLException{
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			c = dataSource.getConnection();
			ps = c.prepareStatement(
					"select count(*) from dept");
			
			rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			throw e;
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
			if(c != null) {
				try {
					c.close();
				} catch (SQLException e) {
				}
			}
		}
	}
	
	

	public static void main(String[] args)throws ClassNotFoundException, SQLException {

	}
}
