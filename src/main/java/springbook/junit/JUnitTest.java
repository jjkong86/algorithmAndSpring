package springbook.junit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class JUnitTest {
	static JUnitTest testO;
	
	@Test public void test1() {
		assertThat(this, is(not(sameInstance(testO))));
		testO = this;
		System.out.println("testO : "+testO);
	}
	@Test public void test2() {
		assertThat(this, is(not(sameInstance(testO))));
		testO = this;
		System.out.println("testO : "+testO);
	}
	@Test public void test3() {
		assertThat(this, is(not(sameInstance(testO))));
		testO = this;
		System.out.println("testO : "+testO);
	}
}
