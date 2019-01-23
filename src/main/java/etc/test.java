package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class test {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringBuilder space = new StringBuilder();
        for (int i = 0; i < input; i++) {
			space.append(" ");
		}
        for (int i=1; i<=input; i++) {
            space.setCharAt(input - i, '*');
            sb.append(space + "\n");
        }
        System.out.println(sb);
        System.out.println(Integer.MAX_VALUE);
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
