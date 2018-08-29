package springbook.chapter6;

import springbook.model.Level;
import springbook.model.User;
import static springbook.chapter5.UserService.MIN_LOGCOUNT_FOR_SILVER;
import static springbook.chapter5.UserService.MIN_RECCOMEND_FOR_GOLD;

public class UserLevelUpgradePolicyOriginal implements UserLevelUpgradePolicy {
	UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public boolean canUpgradeLevel(User user) {
		Level currentLevel = user.getLevel();
		switch(currentLevel) {
		case BASIC : return (user.getLogin () >= MIN_LOGCOUNT_FOR_SILVER);
		case SILVER: return (user.getRecommend() >= MIN_RECCOMEND_FOR_GOLD);
		case GOLD: return false;
		default: throw new IllegalArgumentException("Unkown value : "+currentLevel);
		}
	}

	@Override
	public void upgradeLevel(User user) {
		user.upgradeLevel();
		userDao.update(user);
	}
}