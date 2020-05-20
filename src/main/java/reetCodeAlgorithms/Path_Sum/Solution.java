package reetCodeAlgorithms.Path_Sum;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        return findSum(root, 0, sum);
    }

    public boolean findSum(TreeNode node, int adding, int sum) {
        if (node == null)
            return false;

        adding += node.val;

        if (isLeefNode(node) && adding == sum)
            return true;

        return findSum(node.left, adding, sum) || findSum(node.right, adding, sum);
    }

    public boolean isLeefNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}

