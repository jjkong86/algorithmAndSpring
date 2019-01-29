package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class test {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println((int)-3.5);
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
