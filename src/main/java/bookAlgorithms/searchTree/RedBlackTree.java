package bookAlgorithms.searchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RedBlackTree {
	private static int[] wArray;
	static Tree root;
	static String black;
	static String red;
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
	}
	
	public static Tree redBlackTreeBuild(int[] array, int start, int end) {
		/*
		 *root 노드를 검정색으로 넣어줌, 이진 트리의 법칙에 따라서 ~
		 *다음 삽입되는 노드의 색깔은 무조건 레드 -> double red 발생 ? -> 부모의 형제 노드 색깔에 따라 restructuring, recoloring  
		 * - case1 : 부모 형제노드가 레드 -> 부모와 부모 형제를 블랙으로 바꾸고 부모의 부모를 레드로(root 노드면 다시 블랙으로)
		 * - case2 : 블랙
		 */
		// [14, 19, 36, 37, 38, 48, 52, 82, 94, 95]
		int depth = 1;
		Tree tree = redBlackTreeBuildR(array, start, end, depth);
		return tree;
	}
	
	public static Tree redBlackTreeBuildR(int[] array, int start, int end, int depth) {
		if (start > end) {
			return null;
		}
		int middle = (start+end)/2;
		String color = depth == 1? black : red;
		Tree tree = new Tree(array[middle], color, depth);
		treeColorChange(tree, array[middle]);
		
		tree.left = redBlackTreeBuildR(array, start, middle--, depth++);
		tree.right = redBlackTreeBuildR(array, middle++, end, depth++);
		
		return tree;
	}
	
	public static Tree treeColorChange(Tree tree, int value) {
		Tree parentNode = findParentNode(tree, value, 1);
		if (parentNode != null & parentNode.color.equals(red)) {
			Tree parentParentNode = findParentNode(tree, parentNode.val, 1);
			if (parentParentNode != null & parentParentNode.color.equals(red)) {
				parentParentNode.left.color = black;
				parentParentNode.right.color = black;
				System.out.println("color - "+parentParentNode.right.color + "::"+parentParentNode.left.color);
			} else if (parentParentNode != null & parentParentNode.color.equals(black)) {
				
			}
		}
		
		return tree;
	}

	public static Tree findParentNode(Tree tree, int findVal, int depth) {
		if (tree == null) {
			System.out.println("찾으려는 숫자가 없음 !");
			return null;
		}
		
		if ((tree.left != null && tree.left.val == findVal) || (tree.right != null && tree.right.val == findVal)) {
			return tree;
		}
		
		if (tree.val > findVal) {
			tree = findParentNode(tree.left, findVal, depth++);
		} else if (tree.val < findVal ) {
			tree = findParentNode(tree.right, findVal, depth++);
		} else if (tree.val == findVal) {
			System.out.println("찾는 숫자는 root 노드임!");
		}
		
		return tree;
	}
	
	public static Tree treeBuild(int[] array, int start, int end) {
		Tree tree = treeBuildR(array, start, end, 1);
		return tree;
	}
	
	public static Tree treeBuildR(int[] array, int start, int end, int depth) {
		if (start > end) {
			return null;
		}
		int middle = (start + end)/2;
		System.out.println("노드 삽입 :" + array[middle] + ", dpeth : "+depth);
		Tree tree = new Tree(array[middle], depth++);
		tree.left = treeBuildR(array, start, middle-1, depth);
		tree.right = treeBuildR(array, middle+1, end, depth);
		
		return tree;
	}
	
	public static void findTreeValue(Tree tree, int value) {
		if (tree != null) {
			if (tree.val > value) {
				System.out.println("smaller than "+tree.val + ", depth : "+tree.depth);
				findTreeValue(tree.left, value);
			} else if (tree.val < value) {
				System.out.println("bigger than "+tree.val + ", depth : "+tree.depth);
				findTreeValue(tree.right, value);
			} else if (tree.val == value) {
				System.out.println("find value : "+tree.val + ", depth : "+tree.depth);
			}
		} else {
			System.out.println("찾지 못함");
		}
	}
	
	public static void main(String[] args) {
		Random gen =  new Random();
		int[] array = new int[10];
		int target = 0;
		List<Integer> list = new ArrayList<>();
//		for (int i = 0; i < 10; i++) {
//			int ran = gen.nextInt(100);
//			boolean flag = dupleChk(list, ran);
//			if (!flag) {
//				i--;
//				continue;
//			}
//			list.add(ran);
//			array[i] = ran;
//			target = target != 0? target : ran;
//		}
//		wArray = array;
//		quickSort(0, wArray.length-1);
		
		int[] array1 = {14, 19, 36, 37, 38, 48, 52, 82, 94, 95};
		
		Tree tree = treeBuild(array1, 0, array1.length-1);
		System.out.println("====================================");
		System.out.println("====================================");
		findTreeValue(tree, 95);
		System.out.println("====================================");
		System.out.println("====================================");
		Tree parentNode = findParentNode(tree, 38, 1);
		if (parentNode != null) System.out.println("parentNode : " + parentNode.val + ", dpeth : "+parentNode.depth);
	}
	
	private static boolean dupleChk(List<Integer> list, int value) {
		if (list.contains(value)) {
			return false;
		}
		return true;
	}

	private static int[] quickSort(int start, int end) {
		if (start < end) {
			int result = partition(start, end);
			System.out.println("targetIndex : "+result);
			quickSort(start, result-1);
			quickSort(result+1, end);
		} else {
			return wArray;
		}
		return wArray;
	}
	
	private static int partition(int start, int end) {
		// // 1구역 // target // 3구역 // 4구역(array 처음)
		int target = wArray[end]; // 맨 끝의 원소를 기준원소로 함
		System.out.println("target : "+target);
		int firstIndex = start;
		int thirdIndex = start;
		for (thirdIndex = start; thirdIndex < end; thirdIndex++) { // thirdIndex : 3구역의 시작 지점
			if (target >= wArray[thirdIndex]) {
				int temp = wArray[thirdIndex];
				wArray[thirdIndex] = wArray[firstIndex];
				wArray[firstIndex] = temp;
				firstIndex++;
			}
		}
		int temp = wArray[firstIndex];
		wArray[firstIndex] = wArray[thirdIndex];
		wArray[thirdIndex] = temp;
		
		print(wArray);
		return  firstIndex;
	}

	public static void print(int[] array) {
		StringBuilder print = new StringBuilder("정렬 후 : ["+array[0]+", ");
		for (int j = 1; j < array.length; j++) {
			print.append(array[j]).append(j == array.length-1 ? "" : ", ");
		}
		System.out.println(print+"]");
	}
}
