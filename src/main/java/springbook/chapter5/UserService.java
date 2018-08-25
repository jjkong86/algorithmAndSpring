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
	
	public void upgradeLevels() {
		List<User> users = userDao.getAll();
		
		for(User user : users) {
			if(userLevelUpgradePolicy.canUpgradeLevel(user)) {
				System.out.println(user.getDeptno());
				userLevelUpgradePolicy.upgradeLevel(user);
			}
		}
	}
	
	public void add(User user) {
		if (user.getLevel() == null) user.setLevel(Level.BASIC);
		userDao.add(user);
	}
	
	
}
