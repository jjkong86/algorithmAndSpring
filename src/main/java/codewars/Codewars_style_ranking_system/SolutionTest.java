package codewars.Codewars_style_ranking_system;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// TODO: Replace examples and use TDD development by writing your own tests

public class SolutionTest {
    @Test(expected=Exception.class)
    public void testSomething() {
    	User user = new User.Builder(-8).build();
    	assertEquals(-8, user.rank);
        user.incProgress(-8);
        assertEquals(3, user.progress);
        assertEquals(-8, user.rank);
        user.incProgress(-7);
        user.incProgress(-6);
        assertEquals(53, user.progress);
        user.incProgress(-5);
        try {
        	user.incProgress(-9);
		} catch (Exception e) {
			assertEquals(Exception.class, e.getClass());
		}
    }
    
    @Test
    public void testSomething2() {
    	User user = new User.Builder(-8).build();
    	user.incProgress(-9);
    }
}

