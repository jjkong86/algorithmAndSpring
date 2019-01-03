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
				System.out.println("rear.nextNode : "+rear.val + " - > " + (rear.nextNode.val == front.val ? rear.nextNode.val + "연결 됨" : "front와 rear 연결 안됨"));
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
		int len = Integer.parseInt(br.readLine());
		ListQueue lq = new ListQueue();
		for (int i = 1; i <= len; i++) {
			lq.push(i);
		}
		int nums = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder("<");
		while (lq.front != null) {
			sb.append(lq.numsPop(nums)+", ");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.deleteCharAt(sb.length()-1);
		sb.append(">");
		System.out.println(sb);
	}

}
