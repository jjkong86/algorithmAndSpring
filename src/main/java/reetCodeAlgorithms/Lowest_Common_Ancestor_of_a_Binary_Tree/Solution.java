package reetCodeAlgorithms.Lowest_Common_Ancestor_of_a_Binary_Tree;

import reetCodeAlgorithms.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

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
		Integer[] array = new Integer[] {6,2,8,0,4,7,9,null,null,7,8};
		TreeNode node = TreeNode.buildTreeNode(array);
		System.out.println(node.toString());
		System.out.println(lowestCommonAncestor(node, 2, 8).val);
		
	}
}
