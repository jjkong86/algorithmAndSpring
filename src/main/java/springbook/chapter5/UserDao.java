package springbook.chapter5;

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

import springbook.chapter3.JdbcContext;
import springbook.chapter3.StatementStrategy;
import springbook.model.User;

public class UserDao {
	
	private JdbcTemplate jdbcTemplate;
	
	//applicationContext에서 dataSource주입해줌
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
//		this.dataSource = dataSource;
	}
	
			
	Map<String, String> map = new HashMap<String, String>();
	String query;
	public void deleteAll() {
		String query = "delete from dept";
		this.jdbcTemplate.update(query);
	}

	public void add(final User user) {
		this.jdbcTemplate.update("insert into dept values(?, ?, ?, ?, ?, ?)", user.getDeptno(), user.getDname(), user.getLoc(), user.getLevel().intValue(), user.getLogin(), user.getRecommend());
	}
	
	public void update(final User user) {
		this.jdbcTemplate.update("update dept set dname = ?, loc = ?, level = ?, login = ?, recommend = ? where deptno = ?", user.getDname(), user.getLoc(), user.getLevel().intValue(), user.getLogin(), user.getRecommend(), user.getDeptno());
	}
	
	public User get(Integer deptno) {
		String query = "select * from dept where deptno = ?";
		return this.jdbcTemplate.queryForObject(query, new Object[] {deptno},rowMapper());			
	}
		
	public List<User> getAll() {
		String query = "select * from dept";
		return this.jdbcTemplate.query(query, rowMapper());
	}
	
	public int getCount() {		
		return this.jdbcTemplate.queryForInt("select count(*) from dept");
	}
	
	public RowMapper<User> rowMapper() {
		return new RowMapper<User>() {
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setDeptno(rs.getInt("deptno"));
				user.setDname(rs.getString("dname"));
				user.setLoc(rs.getString("Loc"));
				user.setLevel(Level.valueOf(rs.getInt("level")));
				user.setLogin(rs.getInt("login"));
				user.setRecommend(rs.getInt("recommend"));
				
				return user;
			}
		};
	}
}
