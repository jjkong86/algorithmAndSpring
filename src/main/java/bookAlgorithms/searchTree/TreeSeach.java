package bookAlgorithms.searchTree;

import java.util.Random;

public class TreeSeach {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {val = x; }
	}
	
	public static void main(String[] args) {
		Random gen =  new Random();
		int[] array = new int[10];
		int targetIndex = 0;
		for (int i = 0; i < 10; i++) {
			array[i] = gen.nextInt(100);
			targetIndex = targetIndex != 0? targetIndex : gen.nextInt(10);
		}
		int[] treeArray = {1,2,3,4,5,6,7,8,9,10};
		int[] result = treeInsert(treeArray, 0);
		print(result);
	}
	
	public static int[] treeInsert(int[] treeArray, int left) {
		int len = treeArray.length-1;
		int middle = len/2;
		
		if (left == treeArray.length-1) return treeArray;
		
		int temp = treeArray[middle];
		treeArray[middle] = treeArray[left];
		treeArray[left] = temp;
		
		treeInsert(treeArray, left++);
		
		return treeArray;
	}
	
	public static void print(int[] array) {
		StringBuilder print = new StringBuilder("정렬 후 : ["+array[0]+", ");
		for (int j = 1; j < array.length; j++) {
			print.append(array[j]).append(j == array.length-1 ? "" : ", ");
		}
		System.out.println(print+"]");
	}

}
