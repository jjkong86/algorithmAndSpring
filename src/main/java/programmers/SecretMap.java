package programmers;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class SecretMap {
	
	public static String[] findTreasure(int n, int[] arr1, int[] arr2) {
		String[] converTo = new String[n];
		
		for (int i = 0; i < n; i++) {
			String str1 = makeFull(Integer.toBinaryString(arr1[i]), n);
			String str2 = makeFull(Integer.toBinaryString(arr2[i]), n);
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n; j++) {
				sb.append(str1.charAt(j) == ('0') && str2.charAt(j) == ('0') ? " " : "#");
			}
			converTo[i] = sb.toString();
		}
		System.out.println(Arrays.toString(converTo));
		return converTo;
	}
	
	public static String makeFull(String str, int n) {
		StringBuilder sb = new StringBuilder();
		int len = str.length();
		while(len < n) {
			sb.append("0");
			len++;
		}
		sb.append(str);
		return sb.toString();
	}
	
	public static class TestClass {
		
		@Test
		public void test1() {
			assertThat(new String[] {"#####","# # #", "### #", "#  ##", "#####"},
					is(findTreasure(5, new int[] {9, 20, 28, 18, 11}, new int[] {30, 1, 21, 17, 28})));
		}
		
		@Test
		public void test2() {
			assertThat(new String[] {"######", "###  #", "##  ##", " #### ", " #####", "### # "},
					is(findTreasure(6, new int[] {46, 33, 33 ,22, 31, 50}, new int[] {27 ,56, 19, 14, 14, 10})));
		}
	}
}
