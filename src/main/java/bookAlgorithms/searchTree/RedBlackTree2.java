package bookAlgorithms.searchTree;

public class RedBlackTree2 {
	static Tree root;
	static String black = "black";
	static String red = "red";
	static Tree nullNode = new Tree(0, black);
	
	public static class Tree {
		int val, depth;
		String color;
		Tree left, right;
		Tree(int x, String color) {
			this.val = x;
			this.color = color;
		}
		Tree(int x, String color, int depth) {
			this.val = x;
			this.color = color;
			this.depth = depth;
		}
		Tree(int x, int depth) {
			this.val = x;
			this.depth = depth;
		}
		Tree() {
			this.val = 0;
			this.depth = 0;
		}
	}
	
	public static Tree redBlackTreeBuild(Tree tree, int value) {
		/*
		 *root 노드를 검정색으로 넣어줌, 이진 트리의 법칙에 따라서 ~
		 *다음 삽입되는 노드의 색깔은 무조건 레드 -> double red 발생 ? -> 부모의 형제 노드 색깔에 따라 변경이 필요함
		 * - case1 : 부모 형제노드가 레드 -> 부모와 부모 형제를 블랙으로 바꾸고 부모의 부모를 레드로(root 노드면 다시 블랙으로)
		 * - case2 : 블랙
		 */
		// [14, 19, 36, 37, 38, 48, 52, 82, 94, 95]
		// x : 대상, p : x의 부모, s : p의 형제, p2 = p의 부모
		int depth = 1;
		System.out.println("노드 삽입 :" + value);
		if (tree == null) {
			return new Tree(value, black, depth);
		} else {
			tree = insertTreeNode(tree, value, depth);
		}
		System.out.println("================color 변경 시작====================");
		tree = treeColorChange(tree, value);
		
		return tree;
	}
	
	public static Tree insertTreeNode(Tree tree, int value, int depth) {
		//같은 숫자면 트리의 규칙에 위배 됨으로 return
		//트리의 규칙에 따라서 leaf 노드까지  들어가서 insert함
		if (tree != null && tree.val != value) {
			if (tree.val > value) {
				System.out.println("smaller than "+tree.val);
				insertTreeNode(tree.left, value, depth+1);
			} else {
				System.out.println("bigger than "+tree.val);
				insertTreeNode(tree.right, value, depth+1);
			}
		} else if (tree == null){
			System.out.println("insert value : "+value);
			tree = new Tree(value, red, depth);
		} else {
			System.out.println("트리 원소와 같은 숫자는 삽입 안됨!");
		}
		return tree;
	}
	
	public static Tree treeColorChange(Tree tree, int value) {
		//case1 : 부모가 레드 -> 부모 형제노드가 레드 -> 부모와 부모 형제를 블랙으로 바꾸고 부모의 부모를 레드로(root 노드면 다시 블랙으로)
		Tree parentNode = findParentNode(tree, value, 1); //tree 전체를 넘겨야함
		if (parentNode == null) {
			System.out.println("부모 노드 없음 !!");
			return null;
		}
		if (parentNode.color.equals(red)) {
			System.out.println("p : red");
			Tree grandParentNode = findParentNode(tree, parentNode.val, 1);
			if (grandParentNode == null) return null;
			if (grandParentNode.color.equals(red)) {
				grandParentNode.color = grandParentNode.depth == 1 ? black : red;
				grandParentNode.left.color = black;
				grandParentNode.right.color = black;
				System.out.println("color - "+grandParentNode.right.color + "::"+grandParentNode.left.color);
			}
			
			//p2의 부모가 레드이면 색 바꾸기 재귀로 이용
			Tree ancestorNode = findParentNode(tree, grandParentNode.val, 1);
			if (ancestorNode == null) return null;
			if (ancestorNode.color.equals(red)) {
				treeColorChange(tree, ancestorNode.val);
			}
		} else if (parentNode.color.equals(black)) {
			System.out.println("p : black");
		}

		return tree;
	}
	
	public static Tree findParentNode(Tree tree, int findVal, int depth) {
		if (tree == null) {
			System.out.println("찾으려는 숫자가 없음 !");
			return null;
		} else {
			System.out.println("tree value :" + tree.val + ", findval :"+findVal);
		}
		
		if (tree.left != null) {
			System.out.println("tree.left value : " + tree.left.val);
			
		}
		if (tree.right != null) {
			System.out.println("tree.right value : " + tree.right.val);
			
		} 
		if (tree.left == null && tree.right == null) {
			System.out.println("자식 없음 !");
		}
		if ((tree.left != null && tree.left.val == findVal) || (tree.right != null && tree.right.val == findVal)) {
			return tree;
		}

		if (tree.val > findVal) {
			System.out.println("smaller than "+tree.val + ", depth : "+tree.depth);
			tree = findParentNode(tree.left, findVal, depth++);
		} else if (tree.val < findVal ) {
			System.out.println("bigger than "+tree.val + ", depth : "+tree.depth);
			tree = findParentNode(tree.right, findVal, depth++);
		} else if (tree.val == findVal) {
			System.out.println("찾는 숫자는 root 노드임!");
			return null;
		}

		return tree;
	}
	
	public static void main(String[] args) {
		int[] array = {38, 19, 82, 14, 36, 48, 94, 37, 52, 95};
		for (int i = 0; i < array.length; i++) {
			redBlackTreeBuild(root, array[i]);
		}
		System.out.println("====================================");
		System.out.println("====================================");
		printSetting(root);
	}
	
	public static void printSetting(Tree tree) {
		if (tree != null) {
			printNode(tree);
			printSetting(tree.left);
			printSetting(tree.right);
		}
	}
	
	public static void printNode(Tree tree) {
		System.out.println("tree.val : "+tree.val + ", tree.color : "+tree.color+", tree.depth : "+tree.depth);
	}

}
