package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number10845 {
	
	private static class Node {
		private int val;
		private Node nextNode;
		Node(int data) {
			this.val = data;
			this.nextNode = null;
		}
	}
	// 1 > 2 > 3 > 4 > 5
	//front : 1, rear : 5
	private static class ListQueue {
		private Node front; //가장 먼저 삽입된 노드
		private Node rear;  //가장 최근에 삽입된 노드
		private int size;
		public ListQueue() {
			this.front = null;
			this.rear = null;
			this.size = 0;
		}
		
		public int empty() {
			int ret = front == null ? 1 : 0;
			return ret;
		}
		
		public void push(int data) {
			Node node = new Node(data);
			node.nextNode = null;
			if (empty() == 1) {
				front = node;
				rear = node;
			} else {
				rear.nextNode = node;
				rear = rear.nextNode;
			}
			size++;
//			System.out.println("insert : "+node.val + ", size : "+size+ ", rear val :"+rear.val);
		}
		
		public int pop() {
			int ret;
			if (empty() == 1) {
				System.out.println(-1);
				return -1;
			} else {
				ret = front.val;
				front = front.nextNode;
				size--;
			}
			System.out.println(ret);
			return ret;
		}
		
		public void front() {
			if (empty() == 1) {
				System.out.println(-1);
			} else {
				System.out.println(front.val);
			}
		}
		
		public void back() {
			if (empty() == 1) {
				System.out.println(-1);
			} else {
				System.out.println(rear.val);
			}
		}
		
		public void size() {
			System.out.println(size);
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		ListQueue lq = new ListQueue();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		
		while (len -- > 0) {
			String input = br.readLine();
			switch (input) {
			case "pop":
				lq.pop();
				break;
			case "size":
				lq.size();
				break;
			case "empty":
				System.out.println(lq.empty());
				break;
			case "front":
				lq.front();
				break;
			case "back":
				lq.back();
				break;
			default:
				if (input.startsWith("push")) {
					lq.push(Integer.parseInt(input.split(" ")[1]));
				}
				break;
			}
		}
	}
}
