package reetCodeAlgorithms.Lowest_Common_Ancestor_of_a_Binary_Tree;

import reetCodeAlgorithms.TreeNode;

// 최저 공통 조상, value equals?, dfs
class Solution2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode copy = root;

        while (copy != null) {
            TreeNode temp = this.compare(copy, p, q);
            if (temp.val == copy.val)
                return copy;
            copy = temp;
        }

        return null;
    }

    private TreeNode compare(TreeNode node, TreeNode p, TreeNode q) {
        if (node.val > p.val && node.val > q.val) return node.left;
        else if (node.val < p.val && node.val < q.val) return node.right;
        else return node;
    }
}
