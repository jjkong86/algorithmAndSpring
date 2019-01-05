package dataStructure;

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
public class Dequeue {
	
	public static class DequeNode {
		int val;
		DequeNode backNode;
		DequeNode nextNode;
		
		public DequeNode() {
			this.backNode = null;
			this.nextNode = null;
		}
		
		public DequeNode(int val) {
			this.val = val;
			this.backNode = null;
			this.nextNode = null;
		}
	}
	
	DequeNode front;
	DequeNode rear;
	
	Dequeue() {
		this.front = null;
		this.rear = null;
	}
	
	public boolean empty() {
		return front == null;
	}
	
	public void push_back(int val) {//front
		//node( = front.backNode) - front( = node.nextNode)
		DequeNode node = new DequeNode(val);
		node.backNode = null;
		if (empty()) {
			front = node;
			rear = node;
			node.nextNode = null;
			System.out.println("최초 push : " + node.val);
		} else {
			node.nextNode = front;
			front.backNode = node;
			front = node;
			System.out.println("push_front : "+node.val);
		}
	}
	
	public void push_front(int val) { //rear
		DequeNode node = new DequeNode(val);
		node.nextNode = null;
		if (empty()) {
			front = node;
			rear = node;
			node.backNode = null;
			System.out.println("최초 push : " + node.val);
		} else {
			node.backNode = rear;
			rear.nextNode = node;
			rear = node;
			System.out.println("push_rear : "+node.val);
		}
	}
	
	public int pop_front() {//rear
		int ret = 0;
		if (empty()) {
			ret = -1;
		} else {
			ret = rear.val;
			rear = rear.backNode;
			rear.nextNode = null;
		}
		return ret;
	}
	
	public int pop_back() {//front
		int ret = 0;
		if (empty()) {
			ret = -1;
		} else {
			ret = front.val;
			front = front.nextNode;
			front.backNode = null;
		}
		return ret;
	}
	
	public static void main(String[] args) {
		DequeNode node = new DequeNode();
		
	}
}
