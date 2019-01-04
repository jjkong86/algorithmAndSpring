package dataStructure;

/*
 *Double-Ended Queue 
 * 큐의 양쪽 끝에서 삽입과 삭제가 모두 발생할 수 있는 큐
 *사용하는 방법에 따라서 큐와 스택이 될 수 있음
 *dequeue의구조 : backNode - node - frontNode(node) = backNode(node1) - node1 - frontNode = backNode(node2) - node2 ....
 *insertFront 상황 : backNode(null) - node - frontNode(node) = backNode(front) - front - frontNode -->> front가 node의 frontNode와 front의 backNode를 연결
 * -->> 연결 후 front가 node로 이동함
 *insertRear 상황 : backNode(rear) - rear - frontNode(rear) = backNode(node) - node - frontNode(null) -->> rear가 node의 backNode와 rear의 frontNode를 연결
 * -->> 연결 후 rear가 node로 이동
 * 
 */
public class Dequeue {
	
	public static class DequeNode {
		char data;
		DequeNode backNode;
		DequeNode frontNode;
		
		public DequeNode() {
			this.backNode = null;
			this.frontNode = null;
		}
		
		public DequeNode(char data) {
			this.data = data;
			this.backNode = null;
			this.frontNode = null;
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
	
	public static void main(String[] args) {
		DequeNode node = new DequeNode();
		
	}
}
