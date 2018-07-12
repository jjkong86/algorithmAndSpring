package springbook.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springbook.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class UserDaoTest {
	
	@Autowired
	private ApplicationContext context;
	
	public static void main(String[] args){
		JUnitCore.main("springbook.dao.UserDaoTest");
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
		dao.add(user2);
		dao.add(user3);
		System.out.println(user1.getDeptno() + " : 등록성공");
		System.out.println(user2.getDeptno() + " : 등록성공");
		System.out.println(user3.getDeptno() + " : 등록성공");
		System.out.println("count3 : "+dao.getCount());
		assertThat(user1.getDeptno(), is(dao.get(user1.getDeptno()).getDeptno()));
		assertThat(user2.getDeptno(), is(dao.get(user2.getDeptno()).getDeptno()));
		assertThat(user3.getDeptno(), is(dao.get(user3.getDeptno()).getDeptno()));
		
		
/*		if(dao.get(insertDeptno).getDeptno() == 0) {
		}else {
			System.out.println( "deptno : " + dao.get(insertDeptno).getDeptno() + " > 이미 등록되어 있음");
		}*/
		
		ArrayList<Object> list = dao.list();
		System.out.println(list);
		
		/*		CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
		System.out.println(ccm.getCounter());*/
	}
	
	@Test(expected=EmptyResultDataAccessException.class)
	public void getUserFailure() throws SQLException, ClassNotFoundException{
		System.out.println("실패코드");
		dao.get(1);
	}
	
	@Before
	public void setUp() {
		
		this.dao = context.getBean("userDao", UserDao.class);
		
		this.user1 = new User(10, "개발1부", "서울1");
		this.user2 = new User(20, "개발2부", "서울2");
		this.user3 = new User(30, "개발3부", "서울3");
		
		System.out.println(this.context);
		System.out.println(this);
	}
}
