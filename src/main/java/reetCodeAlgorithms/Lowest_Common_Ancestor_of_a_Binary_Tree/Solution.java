package reetCodeAlgorithms.Lowest_Common_Ancestor_of_a_Binary_Tree;

import java.util.*;

class Solution {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 두 수의 조상을 구해야됨
        // p, q가 조상이 될 수 있음(p=5, q=4 -> output = 5)
        // 각각 루트 노드에서 p와 q를 탐색 -> 탐색이 안되는 루트의 부모값을 리턴
        if (root == null || root == p || root == q) return root;
        root.left = lowestCommonAncestor(root.left, p, q);
        root.right = lowestCommonAncestor(root.right, p, q);
        return root.left == null ? root.right : root.right == null ? root.left : root;
    }
}
