package bookAlgorithms.searchTree;

import java.util.Random;

public class BinaryTreeNode {
	
	private static int[] wArray;
	
	public static class Tree {
		int val;
		Tree left;
		Tree right;
		Tree(int x) { this.val = x; }
	}
	static Tree root;
	
	public static Tree treeBuild(int[] array, int start, int end) {
		root = treeBuildR(array, start, end);
		return root;
	}
	public static Tree treeBuildR(int[] array, int start, int end) {
		if (start > end) {
			return null;
		}
		int middle = (start + end)/2;
		Tree tree = new Tree(array[middle]);
		tree.left = treeBuildR(array, start, middle-1);
		tree.right = treeBuildR(array, middle+1, end);
		
		return tree; 
		
	}
	
	public static void findTreeValue(Tree tree, int value) {
		if (tree != null) {
			if (tree.val > value) {
				System.out.println("smaller than "+tree.val);
				findTreeValue(tree.left, value);
			} else if (tree.val < value) {
				System.out.println("bigger than "+tree.val);
				findTreeValue(tree.right, value);
			} else if (tree.val == value) {
				System.out.println("find value : "+tree.val);
			}
		} else {
			System.out.println("찾지 못함");
		}
	}
	
	public static Tree insertTreeNode(Tree tree, int value) {
		//같은 숫자면 트리의 규칙에 위배 됨으로 return
		//트리의 규칙에 따라서 leaf 노드까지  들어가서 insert함
		if (tree != null && tree.val != value) {
			if (tree.val > value) {
				System.out.println("smaller than "+tree.val);
				tree.left = insertTreeNode(tree.left, value);
			} else {
				System.out.println("bigger than "+tree.val);
				tree.right = insertTreeNode(tree.right, value);
			}
		} else if (tree == null){
			System.out.println("insert value : "+value);
			tree = new Tree(value);
		} else {
			System.out.println("트리 원소와 같은 숫자는 삽입 안됨!");
		}
		return tree;
	}
	
	public static Tree deleteTree(Tree tree, int value) {
		/*
		 * leaf노드 : 그냥 삭제 하면됨
		 * 자식 노드가 하나인 root 노드는 root 노드를 삭제 하고 root 노드의 부모 노드와 root 노드의 자식노드를 연결해 주면 됨
		 * 자식 노드가 2개인 경우 : 삭제 할 root 노드의 자리에 올 수 있는 원소는 오직 두개만 있음 -> 직전 원소와 직후 원소(직후로 정함)
		 *  - 직후 원소 찾는 법 : root 오른쪽 자식 노드에서 왼쪽 자식 노드로 타고 들어감 -> 오른쪽 노드만 갖고 있는 노드가 있음 -> 그 노드의 오른쪽 자식 노드가 직 후 원소임
		 *  - 그 원소를 삭제한 노드 자리에 옮김(b -> a의 자리로 이동) -> 오른쪽 자식을 부모노드에 붙임
		 */
		if (tree != null) {
			if (tree.val > value) {
				System.out.println("smaller than "+tree.val);
				tree.left = findTreeNode(tree.left, value);
			} else if (tree.val < value) {
				System.out.println("bigger than "+tree.val);
				tree.right = findTreeNode(tree.right, value);
			} else if (tree.val == value) {
				System.out.println("find value : "+tree.val);
				tree = deleteTreeNode(tree); 
				
				return tree;
			}
		} else {
			System.out.println("찾지 못함");
			return null;
		}
		return tree;
	}
	
	public static Tree deleteTreeNode(Tree tree) {
		if (tree.left == null && tree.right == null) {		//단말 노드
			return null;
		} else if (tree.left != null && tree.right != null) {		//자식 둘다 있음
			
		} else {		//한쪽 자식만 있음
			return tree.right == null ? tree.left : tree.right;
		}
		return tree;
	}
	
	public static Tree findTreeNode(Tree tree, int value) {
		if (tree != null) {
			if (tree.val > value) {
				System.out.println("smaller than "+tree.val);
				tree.left = findTreeNode(tree.left, value);
			} else if (tree.val < value) {
				System.out.println("bigger than "+tree.val);
				tree.right = findTreeNode(tree.right, value);
			} else if (tree.val == value) {
				System.out.println("find value : "+tree.val);
				return tree;
			}
		} else {
			System.out.println("찾지 못함");
			return null;
		}
		return tree;
	}
	
	
	public static void print(int[] array) {
		StringBuilder print = new StringBuilder("정렬 후 : ["+array[0]+", ");
		for (int j = 1; j < array.length; j++) {
			print.append(array[j]).append(j == array.length-1 ? "" : ", ");
		}
		System.out.println(print+"]");
	}
	
	
	public static void main(String[] args) {
		// 노드 생성
		Tree node1 = new Tree(10);
		Tree node2 = new Tree(5);
		Tree node3 = new Tree(15);
		Tree node4 = new Tree(4);
		Tree node5 = new Tree(7);
		Tree node6 = new Tree(13);
		Tree node7 = new Tree(17);
		Tree node8 = new Tree(20);
        
        // 트리에 노드 추가
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node7.right = node8;
        
//        findTreeValue(node1, 20);
        
        Random gen =  new Random();
		int[] array = new int[10];
		int target = 0;
		for (int i = 0; i < 10; i++) {
			array[i] = gen.nextInt(100);
			target = target != 0? target : array[i];
		}
		wArray = array;
		quickSort(0, wArray.length-1);
//		print(wArray);
		array = wArray;
		Tree resultTree = treeBuild(array, 0, wArray.length-1);
		
//		System.out.println("target : "+target);
//		findTreeValue(resultTree, target);
		System.out.println("====================================");
		System.out.println("====================================");
//		int insertValue = gen.nextInt(100);
//		insertTreeNode(resultTree, insertValue);
//		findTreeValue(resultTree, insertValue);
		System.out.println("target : "+target);
//		deleteTreeNode(resultTree, target);

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
		System.out.println(target);
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
}