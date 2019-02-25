package etc;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestListener;
public class test {

	public static void main(String[] args) throws NumberFormatException, IOException, ParseException {
		
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		
		System.out.println(list.get(0));
		BigDecimal b = new BigDecimal(0.13424);
		System.out.println(b.multiply(BigDecimal.TEN.pow(18)));
		
		System.out.println(new BigDecimal("232456560000000000").divide(BigDecimal.TEN.pow(18)));
		
		String[] str = "0.13424".split("\\.");
		
		System.out.println(str);
		
		
	}
	
	private static void change(Node n, int val) {
		n.val = val;
	}

	static class Node {
		int val;
		Node(){
			this.val = 0;
		}
	}
}
