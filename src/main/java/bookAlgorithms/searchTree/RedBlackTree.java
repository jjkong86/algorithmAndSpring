package bookAlgorithms.searchTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class RedBlackTree {
	private static int[] wArray;
	static Tree root;
	static String black;
	static String red;
	public static class Tree {
		Map<String, Object> map = new HashMap<>();
		Tree left;
		Tree right;
		Tree(int x, String color) {
			this.map.put("val", x);
			this.map.put("color", color);
		}
	}
	
	public static Tree treeBuild(int[] array, int start, int end) {
		/*
		 *root 노드를 검정색으로 넣어줌, 이진 트리의 법칙에 따라서 ~
		 *다음 삽입되는 노드의 색깔은 무조건 레드 -> double red 발생 ? -> restructuring, recoloring 
		 * - restructuring
		 * - recoloring
		 */
		// [14, 19, 36, 37, 38, 48, 52, 82, 94, 95]
		root = new Tree(start, black);
		if(Integer.parseInt((String) root.map.get("val")) > end) {
			root.left = treeBuildR(root, root.left, start, end);
		} else {
			root.right = treeBuildR(root, root.right, start, end);
		}
		
		return root;
	}
	
	public static Tree treeBuildR(Tree parentNode, Tree tree, int start, int end) {
		if (parentNode.map.get("color").equals(black)) {
			
		}
		tree = new Tree(end, red);
		tree.left = new Tree(0, black);
		tree.right = new Tree(0, black);
		return tree;
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
		int[] array1 = {14, 19, 36, 37, 38, 48, 52, 82, 94, 95};
		wArray = array = array1;
		quickSort(0, wArray.length-1);
		
		
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
