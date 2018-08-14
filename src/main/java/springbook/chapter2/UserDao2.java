package springbook.chapter2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import springbook.model.User;

public class UserDao2 {
	
	private ConnectionMaker connectionMaker;
	
/*	public UserDao (ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}*/
	
/*검색을 통해서 의존성 주입 	
	public UserDao () {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		this.connectionMaker = context.getBean("connectionMaker", ConnectionMaker.class);
	}
*/
	//(property name="connectionMaker" ref="connectionMaker" />
	//name : 프로퍼티() 
	//ref : 수정자 메소드를 통해 주입해줄 오브젝트의 빈 이름
	//this.connectionMaker(<-name(프로퍼티)) = connectionMaker(<-ref) <<-- name에 ref주입
	
	/*
		<beans>
			<bean id="connectionMaker" class="springbook.dao.DConnectionMaker" />			
			<bean id="userDao" class="springbook.dao.UserDao"
				<property name="connectionMaker" ref="connectionMaker" />
			</bean>
		</beans>
	  id="connectionMaker" --> ref="connectionMaker" 의존성 주입함, 이름이 같아야함
	*/
	
	public void setConnectionMaker(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}
	
	public User get(Integer deptno) throws ClassNotFoundException, SQLException {
		
		Connection c = connectionMaker.makeConnection();
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
		Connection c = connectionMaker.makeConnection();
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
		Connection c = connectionMaker.makeConnection();
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
		Connection c = connectionMaker.makeConnection();
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

	public static void main(String[] args)throws ClassNotFoundException, SQLException {

	}
}
