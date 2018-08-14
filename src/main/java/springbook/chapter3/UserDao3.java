package springbook.chapter3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import springbook.model.User;

public class UserDao3 {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	//applicationContext에서 dataSource주입해줌
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
//		this.dataSource = dataSource;
	}
	
	/*
	 * dao에서 JdbcContext에 직접 주입
	 * public void setDataSource(DataSource dataSource) {
		this.jdbcContext = new JdbcContext();
		this.jdbcContext.setDataSource(dataSource);
		this.dataSource = dataSource;
	}*/
	
//	private JdbcContext jdbcContext;
//	
//	public void setJdbcContext(JdbcContext jdbcContext) {
//		this.jdbcContext = jdbcContext;
//	}
			
	Map<String, String> map = new HashMap<String, String>();
	String query;
	public void deleteAll() throws SQLException{
		String query = "delete from dept";
/*		String kindQuery = query.substring(0, query.indexOf(" "));
		System.out.println("kindQuery : "+kindQuery);
		map.put("kindQuery", kindQuery);
		map.put("query", query);

		this.jdbcContext.excuteSql(map);
*/		
		this.jdbcTemplate.update(query);
	}

	public void add(final User user) throws ClassNotFoundException, SQLException {
		
/*		this.jdbcContext.workWithStatementStrategy(new StatementStrategy() {
			@Override
			public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
				
				PreparedStatement ps = c.prepareStatement(
						"insert into dept(deptno, dname, loc) values(?, ?, ?)");
				ps.setInt(1, user.getDeptno());
				ps.setString(2, user.getDname());
				ps.setString(3, user.getLoc());
				return ps;
			}
		});*/
		
		this.jdbcTemplate.update("insert into dept values(?, ?, ?)", user.getDeptno(), user.getDname(), user.getLoc());
		
	}
	
	public User get(Integer deptno) throws ClassNotFoundException, SQLException {
		String query = "select * from dept where deptno = ?";
/*		Connection c = dataSource.getConnection();
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
		
		
		return user;*/
		return this.jdbcTemplate.queryForObject(query, new Object[] {deptno},rowMapper());			
	}
		
	public List<User> getAll() throws ClassNotFoundException, SQLException {
		String query = "select * from dept";
/*		Connection c = dataSource.getConnection();
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
		return list;*/
		
		return this.jdbcTemplate.query(query, rowMapper());
	}
	
	public int getCount() throws SQLException{		
		return this.jdbcTemplate.queryForInt("select count(*) from dept");
	}
	
	public RowMapper<User> rowMapper() {
		return new RowMapper<User>() {
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setDeptno(rs.getInt("deptno"));
				user.setDname(rs.getString("dname"));
				user.setLoc(rs.getString("Loc"));
				
				return user;
			}
		};
	}
	
//	public void jdbcContextWithStatementStrategy(StatementStrategy stmt) throws SQLException {
//		
//		Connection c = null;
//		PreparedStatement ps = null;
//		
//		try {
//			c = dataSource.getConnection();
//			ps =  stmt.makePreparedStatement(c);
//			try {
//				ps.executeQuery();
//				System.out.println("executeQuery");
//			} catch (SQLException e) {
//				System.out.println("executeUpdate");
//				ps.executeUpdate();
//			}
//			
//		} catch (SQLException e) {
//			throw e;
//		} finally {
//			if (ps != null) { try { ps .close(); } catch (SQLException e) {} }
//			if (c != null) { try {c.close(); } catch (SQLException e) {} }
//		}
//	}
	
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
}
