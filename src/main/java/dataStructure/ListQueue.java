package dataStructure;

public class ListQueue {
	
	private Node front;
	private Node rear;
	
	ListQueue() {
		this.front = null;
		this.rear = null;
	}
	
	private class Node {
		Object data;
		Node nextNode;
		
		Node(Object data) {
			this.data = data;
			this.nextNode = null;
		}
	}
	//큐가 비어있는지 확인
	public boolean empty() {
		return front == null;
	}
	
	//insert -> rear에 넣음
	public void insert(Object data) {
		Node node = new Node(data);
		node.nextNode = null;
		
		if (empty()) {
			rear = node;
			front = node;
		} else {
			rear.nextNode = node;
			rear = node;
		}
		System.out.println("insert : "+rear.data);
	}
	
	//fornt data 확인
	public Object peek() {
		if (empty()) {
			System.out.println("큐는 비어있음");
			return null;
		}
		return front.data;
	}
	
	//
	public Object remove() {
		Object item = peek();
		if (item == null) {
			return null;
		}
		front = front.nextNode;
		
		if (front == null) {
			rear = null;
		}
		System.out.println("delete : "+item);
		return item;
	}
	
	public static void main(String[] args) {
		ListQueue lq = new ListQueue();
		System.out.println(lq.empty());
		
		lq.insert(5);
		lq.insert(6);
		
		lq.remove();
		lq.remove();
		lq.remove();

	}

}
