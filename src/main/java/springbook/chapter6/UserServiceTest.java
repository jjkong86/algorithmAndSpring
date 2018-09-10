package springbook.chapter6;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static springbook.chapter5.UserService.MIN_LOGCOUNT_FOR_SILVER;
import static springbook.chapter5.UserService.MIN_RECCOMEND_FOR_GOLD;

import java.lang.reflect.Proxy;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;

import springbook.chapter6.UserServiceImpl.TestUserService;
import springbook.chapter6.UserServiceImpl.TestUserServiceException;
import springbook.model.Level;
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
	@Autowired
	PlatformTransactionManager transactionManager;
	
	List<User> users;
	@Before
	public void setup() {
		//this.userDao = context.getBean("userDao", UserDao.class);
			users = Arrays.asList(
			new User(10, "박범진", "p1" , Level.BASIC, MIN_LOGCOUNT_FOR_SILVER-1, 0),
			new User(20, "강명성", "p2", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER, 0),
			new User(30, "신승한 ", "p3", Level.SILVER, 60, MIN_RECCOMEND_FOR_GOLD-1),
			new User(40, "이상호", "p4", Level.SILVER, 60, MIN_RECCOMEND_FOR_GOLD),
			new User(50, "오민규 ", "p5", Level.GOLD, 100, Integer.MAX_VALUE)
			);
	}
	@Test
	public void upgradelevels() throws SQLException {
		userDao.deleteAll();

		User userWithoutLevel = users.get(0);
		userWithoutLevel.setLevel(null);
		
		userService.add(userWithoutLevel);
		List<User> copyUser = users;
		for (User user : copyUser) {
			int result = userDao.update(user);
			if(result != 1) {
				userDao.add(user);
			}
		}
		
		for(User aa : copyUser) {
			System.out.println("1 : [ "+aa.getDeptno()+", " + aa.getDname()+ ", "  + aa.getLoc()+ ", "
					+ aa.getLevel()+ ", "  + aa.getLogin()+ ", " + aa.getRecommend() + " ]");			
		}
		
		userService.upgradeLevels();
		
		checkLevelUpgraded(users.get(0), false);
		checkLevelUpgraded(users.get(1), true);
		checkLevelUpgraded(users.get(2), false);
		checkLevelUpgraded(users.get(3), true);
		checkLevelUpgraded(users.get(4), false);

		System.out.println("------------------------------------------------------------"+"\n"+"------------------------------------------------------------"); 
		List<User> getAll = userDao.getAll();
		for(User aa : getAll) {
			System.out.println("2 : [ "+aa.getDeptno()+", " + aa.getDname()+ ", "  + aa.getLoc()+ ", "
					+ aa.getLevel()+ ", "  + aa.getLogin()+ ", " + aa.getRecommend() + " ]");			
		}

		checkLevel(users.get(0), Level.BASIC);
		checkLevel(users.get(1), Level.SILVER);
		checkLevel(users.get(2), Level.SILVER);
		checkLevel(users.get(3), Level.GOLD);
		checkLevel(users.get(4), Level.GOLD);
	}
	
	private void checkLevelUpgraded(User user, boolean upgraded) {
		User userUpdate = userDao.get(user.getDeptno());
		if (upgraded) {
				assertThat(userUpdate.getLevel(), is(user.getLevel().nextLevel()));
		} else {
			assertThat(userUpdate.getLevel(), is(user.getLevel()));
		}
	}
	
	@Test
	public void upgradeAIIOrNothing() throws SQLException {
		TestUserService testUserService = new TestUserService(users.get(3).getDeptno());
		testUserService.setUserDao(this.userDao);
		testUserService.setTransactionManager(transactionManager);
		testUserService.setUserLevelUpgradePolicy(this.userLevelUpgradePolicy);
		
		TransactionHandler txHandler = new TransactionHandler();
		txHandler.setTarget(testUserService);
		txHandler.setTransactionManager(transactionManager);
		txHandler.setPattern("upgradeLevels");
		UserService txUserService = (UserService)Proxy.newProxyInstance(
				getClass().getClassLoader() ,new Class[] { UserService.class }, txHandler);
				
//		UserServiceTx txUserService = new UserServiceTx();
//		txUserService.setTransactionManager(transactionManager);
//		txUserService.setUserService(testUserService);
		
		List<User> copyUser = users;
		
		userDao.deleteAll();
		
		for(User user : copyUser) {
			userDao.add(user);
		}
		try {
			txUserService.upgradeLevels();
			fail("TestUserServiceException expected");
		} catch (TestUserServiceException e) {
			System.out.println(e.getMessage());
		}
		List<User> getAll2 = userDao.getAll();
		System.out.println("------------------------------------------------------------"+"\n"+"------------------------------------------------------------");
		for(User aa : getAll2) {
			System.out.println("3 : [ "+aa.getDeptno()+", " + aa.getDname()+ ", "  + aa.getLoc()+ ", "
					+ aa.getLevel()+ ", "  + aa.getLogin()+ ", " + aa.getRecommend() + " ]");			
		}
		checkLevelUpgraded(getAll2.get(1), false);
	}
	
	private void checkLevel (User user, Level expectedLevel) {
		User userUpdate = userDao.get(user.getDeptno());
		assertThat(userUpdate.getLevel(), is(expectedLevel));
	}
			
	
}
