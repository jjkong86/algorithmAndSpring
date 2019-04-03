package reetCodeAlgorithms.Maximum_Depth_of_Binary_Tree;

class Solution {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return findMaxDepth(root, 1);
	}

	public int findMaxDepth(TreeNode node, int depth) {
		if (node == null)
			return depth - 1;
		return Math.max(findMaxDepth(node.left, depth + 1), findMaxDepth(node.right, depth + 1));
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
