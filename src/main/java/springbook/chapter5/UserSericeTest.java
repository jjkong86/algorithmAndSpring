package springbook.chapter5;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springbook.model.User;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class UserSericeTest {
	
	@Autowired
	UserService userService;
	@Autowired
	private ApplicationContext context;
	
	List<User> users;
	private UserDao userDao;
	@Before
	public void setup() {
		this.userDao = context.getBean("userDao", UserDao.class);
			users = Arrays.asList(
			new User(10, "박범진", "p1" , Level.BASIC, 49, 0),
			new User(20, "강명성", "p2", Level.BASIC, 50 , 0),
			new User(30, "신승한 ", "p3", Level.SILVER, 60, 29),
			new User(40, "이상호기", "p4", Level.SILVER ,60 ,30),
			new User(50, "오민큐 ", " p5", Level. GOLD, 100, 100),
			new User(60, "전지희", " p6", Level. DIAMOND, 200, 200)
			);
	}
	@Test
	public void upgradelevels() {
		userDao.deleteAll();
		System.out.println(userDao.getCount());
		for (User user : users) {
			userDao.add(user);
		}
		List<User> getAll = userDao.getAll();
		for(User aa : getAll) {
			System.out.println("[ "+aa.getDeptno()+", " + aa.getDname()+ ", "  + aa.getLoc()+ ", "
					+ aa.getLevel()+ ", "  + aa.getLogin()+ ", " + aa.getRecommend() + " ]");			
		}
		
		userService.upgradeLevels();
		System.out.println("------------------------------------------------------------"+"\n"+"------------------------------------------------------------"); 
		
		List<User> getAll2 = userDao.getAll();
		for(User aa : getAll2) {
			System.out.println("[ "+aa.getDeptno()+", " + aa.getDname()+ ", "  + aa.getLoc()+ ", "
					+ aa.getLevel()+ ", "  + aa.getLogin()+ ", " + aa.getRecommend() + " ]");			
		}
		
		checkLevel(users.get(0) , Level.BASIC);
		checkLevel(users.get(1) , Level.SILVER);
		checkLevel(users.get(2) , Level.SILVER);
		checkLevel(users.get(3) , Level.GOLD);
		checkLevel(users.get(4) , Level.GOLD);
	}
	
	private void checkLevel (User user , Level expectedLevel) {
		User userUpdate = userDao.get(user .getDeptno());
		assertThat(userUpdate.getLevel() , is(expectedLevel));
	}
			
	
}
