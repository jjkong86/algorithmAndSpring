package dataStructure.SimpleLinkedList;


public class SimpleLinkedList {
	private Node header;
	private int size;
	
	public SimpleLinkedList(){
		
		header = new Node(null);
		size = 0;
	}
	
	// 단순 연결 리스트 노드
	private class Node{
		
		private Object data;
		private Node nextNode;
		
		Node(Object data){
			
			this.data = data;
			this.nextNode = null;
		}
	}
	
	public void addFirst(Object data) {
		Node newNode = new Node(data);
		newNode.nextNode = header.nextNode;
		header.nextNode = newNode;
		size++;
	}
	
	public void add(int index, Object data) {
		if(index==0){
			addFirst(data);
			return;
		}
		
		Node previous = getNode(index-1);
		Node next = previous.nextNode;
		
		Node newNode = new Node(data);
		previous.nextNode = newNode;
		newNode.nextNode = next;
		size++;
		System.out.println(size);
		
	}
	
	public Object get(int index) {
		return getNode(index).data;
	}
	
	public Node getNode(int index) {
		if (index < 0 || index >= size) {
			 throw new IndexOutOfBoundsException("Index : " + index + ", Size : " + size);
		}
		
		Node node = header.nextNode;
		for (int i = 0; i < index; i++) {
			node = node.nextNode;
		}
		return node;
	}
	
	public Object removeFirst() {
		Node firstNode = getNode(0);
		header.nextNode = firstNode.nextNode;
		size--;
		return firstNode.data;
	}
	
}
