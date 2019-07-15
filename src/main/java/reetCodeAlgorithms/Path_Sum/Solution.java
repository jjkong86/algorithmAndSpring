package reetCodeAlgorithms.Path_Sum;

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
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
    public boolean hasPathSum(TreeNode root, int sum) {
        // root ~ leef node 까지 합계 == sum 경우를 찾아야함
        if (root == null) return false;
        
        return findSum(root, sum, 0);
    }
    
    public boolean findSum(TreeNode node, int sum, int tempSum) {
        if (node == null) return sum == tempSum;
        return findSum(node.left, sum, tempSum + node.val) || 
            findSum(node.right, sum, tempSum + node.val);
    }
}
