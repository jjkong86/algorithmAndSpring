package etc;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
public class test {

	public static void main(String[] args) throws NumberFormatException, IOException, ParseException {
		String test = null;
		String test1 = "";
		System.out.println(test.length() + "::"+test1.length());
		

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
