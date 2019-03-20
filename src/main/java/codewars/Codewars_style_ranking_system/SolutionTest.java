package codewars.Codewars_style_ranking_system;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

// TODO: Replace examples and use TDD development by writing your own tests

public class SolutionTest {
    @Test
    public void testSomething() {
    	User user = new User.Builder().build();
    	assertEquals(-8, user.rank);
        user.incProgress(-8);
        assertEquals(3, user.progress);
        assertEquals(-8, user.rank);
        user.incProgress(-7);
        user.incProgress(-6);
        assertEquals(53, user.progress);
        user.incProgress(-5);
    }
    
    @Test
    public void testSomething2() {
    	User user = new User.Builder().build();
    	try {
    		user.incProgress(-9);	
		} catch (Exception e) {
			assertThat(e.getMessage(), is("incProgress는 8보다 작거나 -8보다 커야하고 0이 아니어야함"));
		}
    	
    }
}

