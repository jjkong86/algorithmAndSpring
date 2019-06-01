package baekJoon.Number1967;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    private static class Tree {
        int val;
        int weight;
        Tree left;
        Tree right;
        
        Tree(int val, int w) {
            this.val = val;
            this.weight = w;
        }
    }
    
    public static Tree treeBuilder(Tree tree, String[] array, int index) {
        Queue<Tree> q = new LinkedList<>();
        Tree rootNode = tree;
        q.add(tree);
        while (array.length-1 >= index) {
            Tree thisTree = q.poll();
            int[] left = paseIntArray(array[index++].split(" "));
            thisTree.left = new Tree(left[1], left[2]);
            q.add(thisTree.left);
            
            int[] right = paseIntArray(array[index++].split(" "));
            if (thisTree.val == right[0]) {
                thisTree.right = new Tree(right[1], right[2]);
                q.add(thisTree.right);
            } else {
                index --;
            }
        }
		return rootNode;
    }
    
    public static void printTree(Tree tree, StringBuilder sb, Queue<Tree[]> q) {
    	while (!q.isEmpty()) {
    		Tree[] treeArray = q.poll();
    		Tree thisNode = treeArray[1];
    		if (thisNode == null) continue;
    		sb.append(treeArray[0].val+" "+thisNode.val+" "+thisNode.weight+"\n");
    		q.add(new Tree[] {thisNode, thisNode.left});
    		q.add(new Tree[] {thisNode, thisNode.right});
    	}
    	System.out.println(sb);
    }
    
    public static int[] paseIntArray(String[] array) {
        int[] nums = new int[array.length];
        IntStream.range(0, array.length).forEach(i -> nums[i] = Integer.parseInt(array[i]));
        return nums;
    }
    
    public static void main(String[] args) throws IOException {
    	/*12
    	1 2 3
    	1 3 2
    	2 4 5
    	3 5 11
    	3 6 9
    	4 7 1
    	4 8 7
    	5 9 15
    	5 10 4
    	6 11 6
    	6 12 10*/
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int len = Integer.parseInt(br.readLine());
            String[] array = new String[len-1];
            for (int i=0; i<len-1; i++) {
                array[i] = br.readLine(); // 부모노드 번호, 자식노드, 가중치
            }
            Tree rootNode = new Tree(Integer.parseInt(array[0].split(" ")[0]), 0);
            Tree tree = treeBuilder(rootNode, array, 0);
            Queue<Tree[]> q = new LinkedList<>();
            q.add(new Tree[] {tree, tree});
            printTree(tree, new StringBuilder(), q);
        }
    }
}
