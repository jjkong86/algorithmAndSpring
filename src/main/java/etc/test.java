package etc;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.mysql.jdbc.StringUtils;

public class test {

	public static void main(String[] args) throws NumberFormatException, IOException, ParseException {
		String s = "1 3 +";
		Stack<Integer> stack = new Stack<>();
		String[] split = s.split(" ");
		int len = split.length;
		for (int i = 0; i < len; i++) {
			String str = split[i];
			char c = str.charAt(0);
			if (c - '0' >= 0 && c - '0' <= 9) {
				stack.push(Integer.parseInt(str));
			} else if (c == '+') {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b + a);
			}
		}
		System.out.println(Double.parseDouble(s));
		
		System.out.println((double)stack.pop());
		
	}

	private static void change(Node n, int val) {
		n.val = val;
	}

	static class Node {
		int val;

		Node() {
			this.val = 0;
		}
	}
}
