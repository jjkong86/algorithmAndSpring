package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *Double-Ended Queue 
 * 큐의 양쪽 끝에서 삽입과 삭제가 모두 발생할 수 있는 큐
 *사용하는 방법에 따라서 큐와 스택이 될 수 있음
 *dequeue의구조 : node1(node.backNode) - node( = front.backNode, node1.nextNode) - front( = node.nextNode, fron1.backNode) - front1( = front.nextNode) ....
 *insertFront 상황 : node( = front.backNode) - front( = node.nextNode) -->> node 생성 후 node.nextNode = front 연결하고,  front.backNode = node 연결
 * ->> front는 node의 위치로 이동
 *insertRear 상황 : rear( = node.backNode) - node( = rear.nextNode) -->> node 생성 후 node.backNode를 rear 와 연결하고 rear.nextNode = node 연결
 * ->> rear는 node의 위치로 이동
 */
public class Number10866 {

	public static class DequeueNode {
		int val;
		DequeueNode backNode;
		DequeueNode nextNode;

		public DequeueNode() {
			this.backNode = null;
			this.nextNode = null;
		}

		public DequeueNode(int val) {
			this.val = val;
			this.backNode = null;
			this.nextNode = null;
		}
	}

	public static class Dequeue {

		DequeueNode front;
		DequeueNode rear;
		int size;

		Dequeue() {
			this.front = null;
			this.rear = null;
			this.size = 0;
		}

		public boolean empty() {
			return front == null;
		}

		public void push_back(int val) {// front
			// node( = front.backNode) - front( = node.nextNode)
			DequeueNode node = new DequeueNode(val);
			node.backNode = null;
			size++;
			if (empty()) {
				node.nextNode = null;
				front = node;
				rear = node;
				// System.out.println("최초 push : " + node.val + ", size : " + size);
			} else {
				node.nextNode = front;
				front.backNode = node;
				front = node;
				// System.out.println("push_front : " + node.val + ", front.val : " + front.val + ", size : " + size);
			}
		}

		public void push_front(int val) { // rear
			DequeueNode node = new DequeueNode(val);
			node.nextNode = null;
			size++;
			if (empty()) {
				node.backNode = null;
				front = node;
				rear = node;
				// System.out.println("최초 push : " + node.val + ", size : " + size);
			} else {
				node.backNode = rear;
				rear.nextNode = node;
				rear = node;
				// System.out.println("push_rear : " + node.val + ", rear.val : " + rear.val + ", size : " + size);
			}
		}

		public int pop_front() {// rear
			int ret = 0;
			if (empty()) {
				ret = -1;
				// System.out.println("empty");
			} else {
				ret = rear.val;
				size--;
				if (rear.backNode != null) {
					rear = rear.backNode;
					rear.nextNode = null;
					// System.out.println("pop : " + ret + ", rear.val :" + rear.val + ", size : " + size);
				} else {
					rear = null;
					front = null;
				}
			}
			return ret;
		}

		public int pop_back() {// front
			int ret = 0;
			if (empty()) {
				ret = -1;
				// System.out.println("empty");
			} else {
				ret = front.val;
				size--;
				if (front.nextNode != null) {
					front = front.nextNode;
					front.backNode = null;
					// System.out.println("pop : " + ret + ", front.val : " + front.val + ", size : " + size);
				} else {
					rear = null;
					front = null;
				}
			}
			return ret;
		}

		public int front() {// rear
			int ret = 0;
			if (empty()) {
				ret = -1;
				// System.out.println("empty");
			} else {
				ret = rear.val;
			}
			return ret;
		}

		public int back() {// front
			int ret = 0;
			if (empty()) {
				ret = -1;
				// System.out.println("empty");
			} else {
				ret = front.val;
			}
			return ret;
		}

		public int size() {
			return size;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		Dequeue dq = new Dequeue();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		for (int i = 0; i < len; i++) {
			String input = br.readLine();
			int print = 0;
			switch (input) {
			case "front":
				print = dq.front();
				break;
			case "back":
				print = dq.back();
				break;
			case "size":
				print = dq.size();
				break;
			case "empty":
				print = dq.empty() == true ? 1 : 0;
				break;
			case "pop_front":
				print = dq.pop_front();
				break;
			case "pop_back":
				print = dq.pop_back();
				break;
			default:
				if (input.startsWith("push_back")) {
					dq.push_back(Integer.parseInt(input.split(" ")[1]));
				} else if (input.startsWith("push_front")) {
					dq.push_front(Integer.parseInt(input.split(" ")[1]));
				}
				print = -2;
				break;
			}
			if (print != -2) {
				 System.out.println(print);
			}
		}
	}
}
