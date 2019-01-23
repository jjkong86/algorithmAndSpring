package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class test {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        if (input.charAt(0) == ' ') {
        	input = input.substring(1);
        }
        if (input.charAt(input.length()-1) == ' ') {
        	input = input.substring(0, input.length()-1);
        }
        
        System.out.println(input);
        
		br.close();
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
