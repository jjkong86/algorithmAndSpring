package springbook.dao.chapter3;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

public class JdbcContext {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void excuteSql(final Map<String, String> map) throws SQLException {
		String kindQuery = map.get("kindQuery");
		if ("delete".equals(kindQuery)) {
			workWithStatementStrategy(
				new StatementStrategy() {
					@Override
					public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
						return c.prepareStatement(map.get("query"));
					}
				}
			);
		}else if (kindQuery.equals("insert")) {
			workWithStatementStrategy(new StatementStrategy() {
				
				@Override
				public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
					return null;
				}
			});
	
		}else if (kindQuery.equals("select")) {
			
		}


	}
	
	public void workWithStatementStrategy(StatementStrategy stmt) throws SQLException {
		
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			c = dataSource.getConnection();
			ps =  stmt.makePreparedStatement(c);
			try {
				ps.executeQuery();
				System.out.println("executeQuery");
			} catch (SQLException e) {
				System.out.println("executeUpdate");
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			if (ps != null) { try { ps .close(); } catch (SQLException e) {} }
			if (c != null) { try {c.close(); } catch (SQLException e) {} }
		}
	}
	
	
}
