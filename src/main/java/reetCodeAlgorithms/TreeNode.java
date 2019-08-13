package reetCodeAlgorithms;

public class TreeNode {
	public Integer val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(Integer x) {
		val = x;
	}
	
	@Override
	public String toString() {
		return "val : "+val + " [ left : " +(left != null ? left.val : "")+"] "
				+ " [ right : " +(right != null ? right.val : "")+"] "; 
	}
}
