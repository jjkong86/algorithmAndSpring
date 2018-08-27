package springbook.chapter5;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
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

import springbook.chapter5.UserService.TestUserService;
import springbook.chapter5.UserService.TestUserServiceException;
import springbook.model.User;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class UserServiceTest {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	UserService userService;
	@Autowired
	private UserLevelUpgradePolicy userLevelUpgradePolicy;
	
	List<User> users;
	@Before
	public void setup() {
		//this.userDao = context.getBean("userDao", UserDao.class);
			users = Arrays.asList(
			new User(10, "박범진", "p1" , Level.BASIC, MIN_LOGCOUNT_FOR_SILVER-1, 0),
			new User(20, "강명성", "p2", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER , 0),
			new User(30, "신승한 ", "p3", Level.SILVER, 60, MIN_RECCOMEND_FOR_GOLD-1),
			new User(40, "이상호", "p4", Level.SILVER ,60 ,MIN_RECCOMEND_FOR_GOLD),
			new User(50, "오민큐 ", "p5", Level.GOLD, 100, Integer.MAX_VALUE)
			);
	}
	@Test
	public void upgradelevels() {
		userDao.deleteAll();
		System.out.println(userDao.getCount());

		User userWithoutLevel = users.get(0);
		userWithoutLevel.setLevel(null);
		
		userService.add(userWithoutLevel);
		
		for (User user : users) {
			int result = userDao.update(user);
			if(result != 1) {
				userDao.add(user);
			}
		}
		
		List<User> getAll = userDao.getAll();
		System.out.println("------------------------------------------------------------"+"\n"+"------------------------------------------------------------");
		for(User aa : users) {
			System.out.println("[ "+aa.getDeptno()+", " + aa.getDname()+ ", "  + aa.getLoc()+ ", "
					+ aa.getLevel()+ ", "  + aa.getLogin()+ ", " + aa.getRecommend() + " ]");			
		}
		
		for (User user : getAll) userService.upgradeLevels(user);
		
		checkLevelUpgraded(users.get(0), false);
		checkLevelUpgraded(users.get(1) , true);
		checkLevelUpgraded(users.get(2) , false);
		checkLevelUpgraded(users.get(3) , true);
		checkLevelUpgraded(users.get(4) , false);

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
	
	private void checkLevelUpgraded(User user, boolean upgraded) {
		User userUpdate = userDao.get(user.getDeptno());
		if (upgraded) {
				assertThat(userUpdate.getLevel(), is(user.getLevel().nextLevel()));
		} else {
			assertThat(userUpdate.getLevel() , is(user.getLevel()));
		}
	}
	
	@Test
	public void upgradeAIIOrNothing() {
		UserService testUserService = new TestUserService(users.get(3).getDeptno());
		testUserService.setUserDao(this.userDao);
		testUserService.setUserLevelUpgradePolicy(this.userLevelUpgradePolicy);
		userDao.deleteAll();
		
		for(User user : users) {
			userDao.add(user);
			try {
				testUserService.upgradeLevels(user);
			} catch (TestUserServiceException e) {
			}
		}
		System.out.println("------------------------------------------------------------"+"\n"+"------------------------------------------------------------");
		for(User aa : users) {
			System.out.println("[ "+aa.getDeptno()+", " + aa.getDname()+ ", "  + aa.getLoc()+ ", "
					+ aa.getLevel()+ ", "  + aa.getLogin()+ ", " + aa.getRecommend() + " ]");			
		}
		System.out.println("------------------------------------------------------------"+"\n"+"------------------------------------------------------------");
		checkLevelUpgraded(users.get(1),false);
				
	}
	
	private void checkLevel (User user , Level expectedLevel) {
		User userUpdate = userDao.get(user .getDeptno());
		assertThat(userUpdate.getLevel() , is(expectedLevel));
	}
			
	
}
