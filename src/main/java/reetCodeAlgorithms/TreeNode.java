package reetCodeAlgorithms;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
	public Integer val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(Integer x) {
		val = x;
	}
	
	public static TreeNode buildTreeNode(Integer[] array) {
		// 원소가 빌드되는 순서대로 온다고 가정함
		// root 노드를 queue에 재귀적으로 넣어놓고 index에 따라 빌드하면 될듯
		
		TreeNode node = new TreeNode(array[0]);
		int index = 0;
		Queue<TreeNode> queueNode = new LinkedList<>();
		queueNode.add(node);
		
		while (!queueNode.isEmpty()) {
			if (index >= array.length-1) break;
			TreeNode rootNode = queueNode.remove();
			if (array[++index] != null) {
				rootNode.left = new TreeNode(array[index]);
				queueNode.add(rootNode.left);
			}
			
			if (array[++index] != null) {
				rootNode.right = new TreeNode(array[index]);
				queueNode.add(rootNode.right);
			}
		}
		System.out.println("root node val : "+node.val);
		return node;
	}
	
	@Override
	public String toString() {
		return "val : "+val + " [ left : " +(left != null ? left.val : "")+"] "
				+ " [ right : " +(right != null ? right.val : "")+"] "; 
	}
}
