package springbook.chapter5;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import springbook.model.User;

public class UserService {
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
	
	protected void upgradeLevels() throws SQLException {
//		TransactionSynchronizationManager.initSynchronization();
//		Connection c = DataSourceUtils.getConnection(dataSource);
//		c.setAutoCommit(false);
		TransactionStatus status =
				this.transactionManager.getTransaction(new DefaultTransactionDefinition());
		
		try {
			List<User> users = userDao.getAll();
			for(User user : users) {
			if(userLevelUpgradePolicy.canUpgradeLevel(user)) {
				userLevelUpgradePolicy.upgradeLevel(user);
			}
			}
			this.transactionManager.commit(status) ;
		} catch (Exception e) {
			this.transactionManager.rollback(status) ;
			throw e;
		}
//			finally {
//			DataSourceUtils.releaseConnection(c,dataSource);
//			TransactionSynchronizationManager.unbindResource(this.dataSource);
//			TransactionSynchronizationManager.clearSynchronization();
//		}
	}
	
	public void add(User user) {
		if (user.getLevel() == null) user.setLevel(Level.BASIC);
		userDao.add(user);
	}
	
	static class TestUserService extends UserService {
		private int deptno;
		
		TestUserService(int deptno) {
			this.deptno = deptno;
		}
		
		protected void upgradeLevels() throws SQLException {
			List<User> users = userDao.getAll();
			for(User user : users) {
				if (user.getDeptno() == this.deptno) throw new TestUserServiceException();
				super.upgradeLevels();
			}
		}
	}
	
	static class TestUserServiceException extends RuntimeException {
	}
}


