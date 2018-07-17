package springbook.dao.chapter2;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import springbook.dao.UserDao;

//UserDao와 DConnectionMaker사이의 런타임 의존관계 주입 작업을 주도하는 존재이며, 
//동시에 IoC방식으로 오브젝트의 생성과 초기화, 제공 등의 작업을 수행하는 컨테이너이다 
//DI 컨테이너라고 불러도 된다.
//<bean id="connectionMaker" class="springbook.dao.DConnectionMaker">
//사용하고 싶으면 applicationContext의 주석을 제거해주고 해야함 
@Configuration 
public class DaoFactory {
	@Bean
	public UserDao2 userDao2() {
		//ConnectionMaker connectionMaker = new DConnectionMaker();
		//UserDao bb = new UserDao(connectionMaker);
		//return bb;		
		//return new UserDao(connectionMaker());
		
		UserDao2 userDao2 = new UserDao2();
		userDao2.setConnectionMaker(connectionMaker());
		return userDao2;
	}
	
	@Bean
	public ConnectionMaker realConnectionMaker() {
		return new DConnectionMaker();
	}
	@Bean
	public ConnectionMaker connectionMaker() {
		return new CountingConnectionMaker(realConnectionMaker());
	}	
	
	@Bean
	public DataSource dataSource() {
	    final String DRIVER = "com.mysql.jdbc.Driver.class";
	    final String URL = "jdbc:mysql://localhost:3306/sys?useSSL=false";
	    final String USER = "root";
	    final String PW = "mysql";
	    
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		
		dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
		dataSource.setUrl(URL);
		dataSource.setUsername(USER);
		dataSource.setPassword(PW);
		
		return dataSource;
	}
	@Bean
	public UserDao userDao() {
		//ConnectionMaker connectionMaker = new DConnectionMaker();
		//UserDao bb = new UserDao(connectionMaker);
		//return bb;		
		//return new UserDao(connectionMaker());
		
		UserDao userDao = new UserDao();
		userDao.setDataSource(dataSource());
		return userDao;
	}
	
}
