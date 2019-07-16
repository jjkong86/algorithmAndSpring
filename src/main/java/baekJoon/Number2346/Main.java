package baekJoon.Number2346;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringJoiner;

public class Main {
    
    public static class ListQueue {
        int val;
        int index;
        ListQueue left;
        ListQueue right;
        ListQueue(int val, int index)  {
            this.val = val;
            this.index = index;
        }
        @Override
        public String toString() {
        	return "val : "+this.val + ", index : "+index;
        }
    }
    
    public static String solution(ListQueue front) {
        StringJoiner sj = new StringJoiner(" ");
        while(front != null) {
        	int val = front.val;
        	sj.add(String.valueOf(front.index));
        	ListQueue tempLeft = front.left;
        	
        	front = move(front, val, val > 0);
        }
        return sj.toString();
    }
    
    public static ListQueue move(ListQueue q, int move, boolean goTo) {
    	if (move == 0) return q;
    	
    	if (goTo) {
    		return move(q.right, move-1, goTo);
    	}
    	return move(q.left, move+1, goTo);
    }
    
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int num = Integer.parseInt(br.readLine());
            String[] split = br.readLine().split(" ");
            ListQueue q = new ListQueue(Integer.parseInt(split[0]), 0);
            ListQueue copy = q;
            for (int i=1; i<num; i++) {
                ListQueue temp = new ListQueue(Integer.parseInt(split[i]), i);
                q.right = temp;
                temp.left = q;
                q = q.right;
            }
            copy.left = q;
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            	bw.write(solution(copy));
            }
        }
    }
}
