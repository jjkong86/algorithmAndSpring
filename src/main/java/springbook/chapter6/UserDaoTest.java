package springbook.chapter6;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springbook.model.Level;
import springbook.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class UserDaoTest {
	
	@Autowired
	private ApplicationContext context;
	
	public static void main(String[] args){
		JUnitCore.main("springbook.chapter5.UserDaoTest");
	}

	private UserDao dao;
	private User user1;
	private User user2;
	private User user3;
	
	@Test
	public void addAndGet() throws SQLException, ClassNotFoundException{
		//ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		//ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		//UserDao dao = context.getBean("userDao", UserDao.class);
		//UserDao2 dao = context.getBean("userDao2", UserDao2.class);
		
		//UserDao dao = new DaoFactory().userDao();
		System.out.println("count1 : "+dao.getCount());
		dao.deleteAll();
		System.out.println("count2 : "+dao.getCount());
		
		dao.add(user1);
//		user1.setDname("개발운영");
//		user1.setLoc("선유도");
//		user1.setLevel(Level.GOLD);
//		user1.setLogin(999);
//		user1.setRecommend(88);
//		dao.update(user1);
		User user1update = dao.get(user1.getDeptno());
		checkSameUser(user1, user1update);
		
		dao.add(user2);
		dao.add(user3);
		System.out.println(dao.get(user1.getDeptno()).getDeptno() + " : 등록성공");
		System.out.println(dao.get(user2.getDeptno()).getDeptno() + " : 등록성공");
		System.out.println(dao.get(user3.getDeptno()).getDeptno() + " : 등록성공");
		System.out.println("count3 : "+dao.getCount());
/*		assertThat(user1.getDeptno(), is(dao.get(user1.getDeptno()).getDeptno()));
		assertThat(user2.getDeptno(), is(dao.get(user2.getDeptno()).getDeptno()));
		assertThat(user3.getDeptno(), is(dao.get(user3.getDeptno()).getDeptno()));*/
		checkSameUser(user1, dao.get(user1.getDeptno()));
		checkSameUser(user2, dao.get(user2.getDeptno()));
		checkSameUser(user3, dao.get(user3.getDeptno()));
		
/*		if(dao.get(insertDeptno).getDeptno() == 0) {
		}else {
			System.out.println( "deptno : " + dao.get(insertDeptno).getDeptno() + " > 이미 등록되어 있음");
		}*/
		
		List<User> getAll = dao.getAll();
		for(User aa : getAll) {
			System.out.println("[ "+aa.getDeptno()+", " + aa.getDname()+ ", "  + aa.getLoc()+ ", "
					+ aa.getLevel()+ ", "  + aa.getLogin()+ ", " + aa.getRecommend() + " ]");			
		}
		
		/*		CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
		System.out.println(ccm.getCounter());*/
	}
	
	private void checkSameUser(User user1 , User user2) {
		assertThat(user1.getDeptno() , is(user2.getDeptno()));
		assertThat(user1.getDname() , is(user2.getDname()));
		assertThat(user1.getLoc() , is(user2.getLoc()));
		assertThat(user1.getLevel() , is(user2.getLevel()));
		assertThat(user1.getLogin() , is(user2.getLogin()));
		assertThat(user1.getRecommend() , is(user2.getRecommend()));
	}
	
	@Test(expected=EmptyResultDataAccessException.class)
	public void getUserFailure() throws SQLException, ClassNotFoundException{
		System.out.println("실패코드");
		dao.get(1);
	}
	
	@Before
	public void setUp() {
		this.dao = context.getBean("userDao", UserDao.class);
		this.user1 = new User(10, "개발1부", "서울1", Level.BASIC, 1, 0);
		this.user2 = new User(20, "개발2부", "서울2", Level.SILVER, 55 , 19);
		this.user3 = new User(30, "개발3부", "서울3", Level.GOLD, 199, 40);
		
		System.out.println(this.context);
		System.out.println("this : "+this);
	}
}
