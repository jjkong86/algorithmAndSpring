package etc;

import java.io.IOException;
public class test {

	public static void main(String[] args) throws IOException {
		Node n = new Node();
		n.val = 3;
		System.out.println(n.val);
		int val = 10;
		change(n, val);
		System.out.println(n.val);
	}
	String a = "13";
	
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
