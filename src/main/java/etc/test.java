package etc;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
public class test {

	public static void main(String[] args) throws IOException {
		Node n = new Node();
		n.val = 3;
		System.out.println(n.val);
		int val = 10;
		change(n, val);
		System.out.println(n.val);
		
		HashMap<String, Integer> map = new HashMap<>();
		
		BigInteger b = new BigInteger("10");
		b = b.add(BigInteger.ONE);
		System.out.println(b);
		
		int[][] ss = new int[3][4];
		System.out.println(ss.length);
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
