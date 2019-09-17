package reetCodeAlgorithms.Find_Common_Characters;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.*;
import org.junit.Test;

class Solution {
	public static List<String> commonChars(String[] A) {
        List<String> list = new ArrayList<>();
        
        String str = A[0];
        for (char c : str.toCharArray()) {
            String temp = String.valueOf(c);
            int count = 1;
            for (int i=1; i<A.length; i++) {
                int index = A[i].indexOf(temp);
                if (index >= 0) {
                    count ++;
                    A[i] = A[i].substring(0, index) + A[i].substring(index+1);
                }
            }
            if (A.length == count) {
                list.add(temp);
            }
            
        }

        return list;
    }

	public static class TestClass {

		@Test
		public void test1() {
			assertThat(Arrays.asList(new String[] { "e", "l", "l" }),
					is(commonChars(new String[] { "bella", "label", "roller" })));
		}

		@Test
		public void test2() {
			assertThat(Arrays.asList(new String[] {}), is(commonChars(new String[] { "acabcddd", "bcbdbcbd", "baddbadb",
					"cbdddcac", "aacbcccd", "ccccddda", "cababaab", "addcaccd" })));

		}
	}
}
