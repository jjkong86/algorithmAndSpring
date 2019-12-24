package reetCodeAlgorithms.LRU_Cache;

class LRUCache {

	public static class Node {
		int key;
		int value;
		Node prev;
		Node next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	int capacity;
	int size;
	Node head;
	Node tail;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		Node node = head;
		while (node != null) {
			if (node.key == key) {
				moveNodeToHead(node);
				return node.value;
			}
			node = node.next;
		}
		return -1;
	}

	public void put(int key, int value) {
		Node node = new Node(key, value);
		if (head == null) {
			head = node;
			tail = node;
			tail.prev = head;
			size++;
			return;
		}

		if (capacity <= size) {
			if (size == 1) {
				clear();
			} else {
				tail = tail.prev;
				tail.next = null;
				size--;
			}
		}
		addNodeToFirst(node);
	}

	private void moveNodeToHead(Node node) {
		if (node == head) {
			return;
		} else if (node.prev != null && node.next != null) {
			Node tempPrev = node.prev;
			Node tempNext = node.next;
			tempPrev.next = tempNext;
			tempNext.prev = tempPrev;
		} else {
			tail = node.prev;
			tail.next = null;
		}
		addNodeToFirst(node);
	}
	

	private void clear() {
		head = head.next = tail = tail.prev = null;
	}

	private void addNodeToFirst(Node node) {
		node.next = head;
		head.prev = node;
		head = node;
		size++;
	}

	public static void main(String[] args) {
		LRUCache c = new LRUCache(1);
		c.put(2, 1);
		System.out.println(c.get(2));
		c.put(3, 2);
		System.out.println(c.get(2));
		System.out.println(c.get(3));
	}
}
