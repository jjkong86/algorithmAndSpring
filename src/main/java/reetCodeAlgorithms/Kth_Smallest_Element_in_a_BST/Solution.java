package reetCodeAlgorithms.Kth_Smallest_Element_in_a_BST;

import java.util.Arrays;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

	public static class TreeNode {
		Integer val;
		TreeNode left;
		TreeNode right;

		TreeNode(Integer x) {
			val = x;
		}
	}

	public int kthSmallest(TreeNode root, int k) {
		// root.val을 기준으로 왼쪽의 노드 개수를 구해봄.
        // k<=count면 왼쪽에 원하는 k번째 숫자가 있음, 반대면 k-1-count번째가 오른쪽에 있음
		int count = countNodes(root.left);
		if (k <= count) {
			return kthSmallest(root.left, k);
		} else if (k > count + 1) {
			return kthSmallest(root.right, k - 1 - count);
		}

		return root.val;
	}

	public int countNodes(TreeNode n) {
		if (n == null)
			return 0;

		return 1 + countNodes(n.left) + countNodes(n.right);
	}
}
