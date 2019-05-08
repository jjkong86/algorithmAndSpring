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
        TreeNode parentNode = root;
        return searchTree(root, parentNode, p.val, q.val);
    }
    
    public TreeNode searchTree(TreeNode node, TreeNode parentNode, int p, int q) {
        while (node != null) {
            boolean findElement = searchTreeNode(node, parentNode, p, false, q, false);
            if (!findElement) {
                return parentNode;
            } else {
                
            }
        }
        return parentNode;
    }
    
    public boolean searchTreeNode(TreeNode node, TreeNode parentNode, 
        int p, boolean pFlag, int q, boolean qFlag) {
        while (node != null) {
            if (node.val == p) {
                pFlag = true;
            } else if (node.val == q) {
                qFlag = true;
            }
            searchTreeNode(node.left, parentNode, p, pFlag, q, qFlag);
            searchTreeNode(node.right, parentNode, p, pFlag, q, qFlag);
            
        }
		return qFlag;
    }
    
}
