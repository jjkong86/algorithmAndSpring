package springbook.chapter5;

import java.util.List;

import springbook.model.User;

public class UserService {
	UserDao userDao;
	UserLevelUpgradePolicy userLevelUpgradePolicy;
	
	public static final int MIN_LOGCOUNT_FOR_SILVER = 50;
	public static final int MIN_RECCOMEND_FOR_GOLD = 30;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void setUserLevelUpgradePolicy(UserLevelUpgradePolicy userLevelUpgradePolicy) {
		this.userLevelUpgradePolicy = userLevelUpgradePolicy;
	}
	
	protected void upgradeLevels(User user) {
		if(userLevelUpgradePolicy.canUpgradeLevel(user)) {
			userLevelUpgradePolicy.upgradeLevel(user);
		}
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
		
		protected void upgradeLevels(User user) {
			if (user.getDeptno() == this.deptno) throw new TestUserServiceException();
			super.upgradeLevels(user);
		}
	}
	
	static class TestUserServiceException extends RuntimeException {
		
	}
}


