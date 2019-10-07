package reetCodeAlgorithms.Maximum_Depth_of_N_ary_Tree;

import reetCodeAlgorithms.Node;

public class Solution {
	public int maxDepth(Node root) {
		if (root == null || root.children == null)
			return 0;
		return maxDepthCount(root, 1);
	}

	private int maxDepthCount(Node node, int maxCount) {
		if (node == null || node.children == null || node.children.isEmpty()) {
			return maxCount;
		}

		int result = 0;
		for (Node temp : node.children) {
			result = Math.max(result, maxDepthCount(temp, maxCount + 1));
		}
		return result;
	}
}
