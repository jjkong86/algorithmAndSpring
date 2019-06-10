package reetCodeAlgorithms.Kth_Smallest_Element_in_a_BST;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
class Solution2 {
	
	public static class TreeNode {
		Integer val;
		TreeNode left;
		TreeNode right;

		TreeNode(Integer x) {
			val = x;
		}
	}
	
    public int kthSmallest(TreeNode root, int k) {
        // 노드에서 k번째 작은 수를 리턴
        // 가장 작은 수 부터 찾아서 해야하나?
        // 깊이 탐색부터 해봐야할듯
        
        Set<Integer> list = new TreeSet<>();
        makeArrayByNodeVal(root, list, k);
        //System.out.println(list.toString());
        //Collections.sort(list);
        int index = 0;
        int res = 0;
        for (Integer i : list){
            if (k-1 == index++) return i;
        }
        
        return res;
    }
    
    private void makeArrayByNodeVal(TreeNode node, Set<Integer> list, int k) {
        if (node == null) return;
        
        if (list.size() < k) {
            makeArrayByNodeVal(node.left, list, k);
            makeArrayByNodeVal(node.right, list, k);
            list.add(node.val);
        }
    }
}
