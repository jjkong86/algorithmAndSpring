package springbook.chapter6.learningTest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

public class ReflectionTest {
	@Test
	public void invokeMethod() throws Exception {
	String name = "Spring";
	// length()
	assertThat(name.length(), is(6));
	Method lengthMethod = String.class.getMethod("length");
	assertThat((Integer)lengthMethod.invoke(name), is(6));
	// charAt()
	assertThat(name.charAt(0), is('S'));
	Method charAtMethod = String.class.getMethod("charAt", int.class);
	assertThat((Character)charAtMethod.invoke(name, 0), is('S'));
	}
	
	@Test
	public void test11() {
		String name = "jj";
		Hello proxiedHello = (Hello)Proxy.newProxyInstance(
			getClass().getClassLoader(),
			new Class[] { Hello.class},
			new UppercaseHandler(new HelloTarget()));
		System.out.println(proxiedHello.sayHello(name) +" : : "+ proxiedHello.sayThankYou(name));
	}
}
