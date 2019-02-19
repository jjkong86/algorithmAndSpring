package etc;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
public class test {

	public static void main(String[] args) throws NumberFormatException, IOException, ParseException {
		
		int[][] array = new int[5][2];
		array[1][0] = 1;
		array[1][1] = 2;
		array[2][0] = 3;
		array[2][1] = 4;
		
		System.out.println(array[1]);
		
		System.out.println((double)13424/100000);

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
