package springbook.chapter5;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static springbook.chapter5.UserService.MIN_LOGCOUNT_FOR_SILVER;
import static springbook.chapter5.UserService.MIN_RECCOMEND_FOR_GOLD;

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
public class UserServiceTest {
	
	@Autowired
	UserService userService;
	@Autowired
	private ApplicationContext context;
	
	List<User> users;
	private UserDao userDao;
	@Before
	public void setup() {
		this.userDao = context.getBean("userDao", UserDao.class);
		this.userService = context.getBean("userService", UserService.class);
			users = Arrays.asList(
			new User(10, "박범진", "p1" , Level.BASIC, MIN_LOGCOUNT_FOR_SILVER-1, 0),
			new User(20, "강명성", "p2", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER , 0),
			new User(30, "신승한 ", "p3", Level.SILVER, 60, MIN_RECCOMEND_FOR_GOLD-1),
			new User(40, "이상호", "p4", Level.SILVER ,60 ,MIN_RECCOMEND_FOR_GOLD),
			new User(50, "오민큐 ", " p5", Level.GOLD, 100, Integer.MAX_VALUE)
			);
	}
	@Test
	public void upgradelevels() {
		userDao.deleteAll();
		System.out.println(userDao.getCount());

		User userWithLevel = users.get(4);
		User userWithoutLevel = users.get(0);
		userWithoutLevel.setLevel(null);
		
		userService.add(userWithLevel);
		userService.add(userWithoutLevel);
		
		for (User user : users) {
			int result = userDao.update(user);
			if(result != 1) {
				userDao.add(user);
			}
		}
		
		User userWithLevelRead = userDao.get(userWithLevel.getDeptno());
		User userWithoutLevelRead = userDao.get(userWithoutLevel.getDeptno());
		
		assertThat(userWithLevelRead.getLevel(), is(userWithLevel.getLevel()));
		assertThat(userWithoutLevelRead.getLevel(), is(Level .BASIC));
		
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
