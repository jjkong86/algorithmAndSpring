package springbook.chapter6;

import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import springbook.model.User;

public interface UserDao {
	
	public void deleteAll();

	public void add(final User user);
	
	public int update(final User user);
	
	public User get(Integer deptno);
		
	public List<User> getAll();
	
	public int getCount();
	
	public RowMapper<User> rowMapper();
}
