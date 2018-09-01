package springbook.chapter6;

import java.sql.SQLException;
import java.util.List;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import springbook.model.Level;
import springbook.model.User;

public class UserServiceImpl implements UserService {
	UserDao userDao;
	UserLevelUpgradePolicy userLevelUpgradePolicy;
	private PlatformTransactionManager transactionManager;
	
	public static final int MIN_LOGCOUNT_FOR_SILVER = 50;
	public static final int MIN_RECCOMEND_FOR_GOLD = 30;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void setUserLevelUpgradePolicy(UserLevelUpgradePolicy userLevelUpgradePolicy) {
		this.userLevelUpgradePolicy = userLevelUpgradePolicy;
	}
//	public void setDataSource(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}
	public void setTransactionManager(PlatformTransactionManager
			transactionManager) {
			this.transactionManager = transactionManager;
	}
	
	public void upgradeLevels() throws SQLException {
		upgradeLevelslnternal();
	}
	
	private void upgradeLevelslnternal() {
		List<User> users = userDao.getAll();
		for(User user : users) {
			if(userLevelUpgradePolicy.canUpgradeLevel(user)) {
				userLevelUpgradePolicy.upgradeLevel(user);
			}
		}
	}
	
	public void add(User user) {
		if (user.getLevel() == null) user.setLevel(Level.BASIC);
		userDao.add(user);
	}
	
	static class TestUserService extends UserServiceImpl {
		private int deptno;
		
		TestUserService(int deptno) {
			this.deptno = deptno;
		}
		
		public void upgradeLevels() throws SQLException {
			List<User> users = userDao.getAll();
			for(User user : users) {
				if (user.getDeptno() == this.deptno) throw new TestUserServiceException();
				if(userLevelUpgradePolicy.canUpgradeLevel(user)) {
					userLevelUpgradePolicy.upgradeLevel(user);
				}
			}
		}
	}
	
	static class TestUserServiceException extends RuntimeException {
	}
}


