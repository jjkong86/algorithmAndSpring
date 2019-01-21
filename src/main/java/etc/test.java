package etc;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
public class test {

	public static void main(String[] args) throws IOException {
		System.out.println(98.5/100);
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
