package baekJoon;

public class Number10866 {
	//앞과 뒤의 정보가 필요하기 때문에 큐로 구현하면 좋을듯
	//원형 큐 활용할까? -> rear.nextNode = front
	//push front - > rear.nextNode에 넣어 놓고
	class Node {
		int val;
		Node nextNode;
		Node(int val) {
			this.val = val;
		}
	}
	
	static class ListQueue {
		Node front;
		Node rear;
		public ListQueue() {
			this.front = null;
			this.rear = null;
		}
		
		
	}
	
	public static void main(String[] args) {
		
	}

}
