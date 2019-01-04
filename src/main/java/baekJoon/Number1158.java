package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number1158 {

	private static class Node {
		int val;
		Node nextNode;
		Node(int val) {
			this.val = val;
		}
	}
	
	private static class ListQueue {
		Node front;
		Node rear;
		
		public ListQueue() {
			this.front = null;
			this.rear = null;
		}
		
		public boolean empty() {
			return front == null ? true : false;
		}
		
		public void push(int val) {
			Node node = new Node(val);
			if (empty()) {
				front = node;
				rear = node;
			} else {
				rear.nextNode = node;
				rear = rear.nextNode;
				rear.nextNode = front;
			}
		}
		
		public int numsPop(int val) {
			int ret = 0;
			while (val-- > 1) {
					rear = rear.nextNode;
					front = front.nextNode;
			}
			ret = front.val;
			front = front.nextNode;
			rear.nextNode = front;
			
			return ret;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//원형 queue 구현하여 활용하면 될듯
		//rear.nextNode가 항상 front 노드를 바라보면 원형큐가 됨
		//insert 상황 -> rear.nextNode = node; rear = rear.nextNode; rear.nextNode = front;
		//delete 상황 -> front = front.nextNode; rear.nextNode = front;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] array = br.readLine().split(" ");
		int insertNum = Integer.parseInt(array[0]);
		ListQueue lq = new ListQueue();
		for (int i = 1; i <= insertNum; i++) {
			lq.push(i);
		}
		
		int nums = Integer.parseInt(array[1]);
		StringBuilder sb = new StringBuilder("<");
		while (insertNum -- > 0) {
			sb.append(insertNum == 0 ? lq.numsPop(nums) : lq.numsPop(nums)+", ");
		}
		sb.append(">");
		System.out.println(sb);
	}

}
