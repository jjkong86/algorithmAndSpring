package etc;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
public class test {

	public static void main(String[] args) throws NumberFormatException, IOException, ParseException {
		
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		
		System.out.println(list.get(0));

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
