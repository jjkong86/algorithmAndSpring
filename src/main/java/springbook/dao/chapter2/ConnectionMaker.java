package springbook.dao.chapter2;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration 
public interface ConnectionMaker {
	@Bean
	public Connection makeConnection () throws ClassNotFoundException,SQLException;
}
