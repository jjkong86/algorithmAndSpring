package bookAlgorithms.searchTree;

public class TreeNode {
	
	public static class Tree {
		int val;
		Tree left;
		Tree right;
		Tree(int x) { this.val = x; }
	}
	
	public static void findTreeValue(Tree tree, int value) {
		if (tree != null) {
			if (tree.val > value) {
				System.out.println("smaller than "+tree.val);
				findTreeValue(tree.left, value);
			} else if (tree.val < value) {
				System.out.println("bigger than "+tree.val);
				findTreeValue(tree.right, value);
			} else if (tree.val == value) {
				System.out.println("find value : "+tree.val);
			}
		} else {
			System.out.println("찾지 못함");
		}
	}
	
	
	public static void main(String[] args) {
		// 노드 생성
		Tree node1 = new Tree(10);
		Tree node2 = new Tree(5);
		Tree node3 = new Tree(15);
		Tree node4 = new Tree(4);
		Tree node5 = new Tree(7);
		Tree node6 = new Tree(13);
		Tree node7 = new Tree(17);
		Tree node8 = new Tree(20);
        
        // 트리에 노드 추가
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node7.right = node8;
        
        findTreeValue(node1, 20);

	}

}
