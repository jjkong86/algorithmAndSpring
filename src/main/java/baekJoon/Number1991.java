package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class Number1991 {
	public static class Tree {
		char val;
		Tree left;
		Tree right;

		Tree(char val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

	public static Tree buildTree(List<String> array) {
		Tree tree = null;
		for (int i = 0; i < array.size(); i++) {
			String str = array.get(i);
			if (tree == null) {
				tree = new Tree(str.charAt(0));
				if (str.charAt(1) != '.') tree.left = new Tree(str.charAt(1));
				if (str.charAt(2) != '.') tree.right = new Tree(str.charAt(2));
//				System.out.println("root : "+tree.val + ", left : "+(tree.left != null ? tree.left.val : " ") + ", right : "+(tree.right != null ? tree.right.val:""));
			}else {
				findTreeAndInsert(tree, str);
			}
		}
		return tree;
	}
	
	public static void findTreeAndInsert(Tree tree, String str) {
		if (tree != null) {
			if (tree.val == str.charAt(0)) {
				if (str.charAt(1) != '.') tree.left = new Tree(str.charAt(1));
				if (str.charAt(2) != '.') tree.right = new Tree(str.charAt(2));
//				System.out.println("root : "+tree.val + ", left : "+(tree.left != null ? tree.left.val : " ") + ", right : "+(tree.right != null ? tree.right.val:""));
			}
			if(tree.left != null) findTreeAndInsert(tree.left, str);
			if(tree.right != null) findTreeAndInsert(tree.right, str);
		}
	}
	
	public static String preorder(Tree tree) {
		//루트 왼 오
		if (tree == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(String.valueOf(tree.val));
		if (tree.left != null) sb.append(preorder(tree.left));
		if (tree.right != null) sb.append(preorder(tree.right));
		return sb.toString();
	}
	
	public static String inorder(Tree tree) {
		//왼 루트 오
		if (tree == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		if (tree.left != null) sb.append(inorder(tree.left));
		sb.append(String.valueOf(tree.val));
		
		if (tree.right != null) sb.append(inorder(tree.right));
		return sb.toString();
	}
	
	public static String postorder(Tree tree) {
		//왼 오 루트
		if (tree == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		if (tree.left != null) sb.append(postorder(tree.left));
		if (tree.right != null) sb.append(postorder(tree.right));
		sb.append(String.valueOf(tree.val));
		return sb.toString();
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 전위 순회 : 루트, 왼쪽 자식, 오른쪽 자식
		// 중위 순회 : 왼쪽 자식, 루트, 오른쪽 자식
		// 후위 순회 : 왼쪽 자식, 오른쪽 자식, 루트
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int treeSize = Integer.parseInt(br.readLine());
		List<String> list = new ArrayList<>();
		for (int i = 0; i < treeSize; i++) {
			list.add(String.join("", Arrays.asList(br.readLine().split(" "))));
		}
		Tree tree = buildTree(list);
		
		StringJoiner sj = new StringJoiner("\n");
		sj.add(preorder(tree));
		sj.add(inorder(tree));
		sj.add(postorder(tree));
		System.out.println(sj);
		br.close();
	}
}
