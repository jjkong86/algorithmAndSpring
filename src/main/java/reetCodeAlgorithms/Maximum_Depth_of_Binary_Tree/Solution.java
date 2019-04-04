package reetCodeAlgorithms.Maximum_Depth_of_Binary_Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
	
	public static void main(String[] args) {
		char[] c = new char[]{'h','e','l','l','o'};
		int end = c.length-1;
		List<Integer> list = new ArrayList<>();
		Collections.reverse(list);
		for (int i = 0; i < c.length; i++) {
			if (i < end) {
				char temp = c[end];
				c[end--] = c[i];
				c[i] = temp;
			}
		}
	}
}
