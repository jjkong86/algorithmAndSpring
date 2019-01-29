package etc;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
public class test {

	public static void main(String[] args) throws NumberFormatException, IOException, ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("HH|mm|ss");
		String[] split = "01|15|59, 1|47|16, 01|17|20, 1|32|34, 2|17|17".split(", ");
		for (int i = 0; i < split.length; i++) {
			long aa = formatter.parse(split[i]).getTime();
//			System.out.println(aa);
//			System.out.println(formatter.format(aa));
		}
		String[] split2 = "01|15|59, 02|17|17".split(", ");
		System.out.println(formatter.format(formatter.parse(split2[1]).getTime() - formatter.parse(split2[0]).getTime() + formatter.parse("0|00|00").getTime()));
		System.out.println(formatter.parse("01|01|18").getTime());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH|mm|ss");
		Date curDate = new Date();
		System.out.println(dateFormat.parse("0|00|00").getTime());
		System.out.println(dateFormat.parse("01|02|00").getTime());
		System.out.println(dateFormat.parse(dateFormat.format(curDate)).getTime());

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
