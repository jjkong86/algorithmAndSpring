package etc;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.IntStream;

import com.mysql.jdbc.StringUtils;

public class test {

	public static void main(String[] args) throws NumberFormatException, IOException, ParseException {
		int[] array = new int[] {5,654,3,4,5};
		System.out.println(IntStream.of(array).reduce(0, Integer::sum));
		
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
