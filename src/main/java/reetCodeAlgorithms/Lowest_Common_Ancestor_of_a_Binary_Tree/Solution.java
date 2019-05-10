package reetCodeAlgorithms.Lowest_Common_Ancestor_of_a_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	public static TreeNode buildTreeNode(Integer[] array) {
		// 원소가 빌드되는 순서대로 온다고 가정함
		// root 노드를 queue에 재귀적으로 넣어놓고 index에 따라 빌드하면 될듯
		
		TreeNode node = new TreeNode(array[0]);
		int index = 0;
		Queue<TreeNode> queueNode = new LinkedList<>();
		queueNode.add(node);
		
		while (!queueNode.isEmpty()) {
			if (index >= array.length-1) break;
			System.out.println(index + "::"+array[index]);
			TreeNode rootNode = queueNode.remove();
			if (array[++index] != null) {
				rootNode.left = new TreeNode(array[index]);
				queueNode.add(rootNode.left);
			}
			
			if (array[++index] != null) {
				rootNode.right = new TreeNode(array[index]);
				queueNode.add(rootNode.right);
			}
		}
		System.out.println("root node val : "+node.val);
		return node;
	}

	
    public static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        // 두 수의 조상을 구해야됨
        // p, q가 조상이 될 수 있음(p=5, q=4 -> output = 5)
        // root.left 탐색 -> p,q,null 이면 return root
    	// root.right 탐색 -> p,q,null 이면 return root
    	// left == null -> root 노드의 오른쪽에 p,q가 있는것임
    	if (root == null || root.val == p || root.val == q) return root;
    	root.left = lowestCommonAncestor(root.left, p, q);
    	root.right = lowestCommonAncestor(root.right, p, q);
        return root.left == null ? root.right : root.right == null ? root.left : root;
    }
    
    public static void main(String[] args) {
		Integer[] array = new Integer[] {3,5,1,6,2,0,8,null,null,7,4};
		TreeNode node = buildTreeNode(array);
		System.out.println(lowestCommonAncestor(node, 6, 2).val);
		
	}
}
