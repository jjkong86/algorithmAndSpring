package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Number1991 {
	static class Tree {
		String val;
		Tree left;
		Tree right;
		Tree(String val){
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}
	static Tree buildTree(String[] array) {
		return null;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//전위 순회 : 루트, 왼쪽 자식, 오른쪽 자식
		//중위 순회 : 왼쪽 자식, 루트, 오른쪽 자식
		//후위 순회 : 왼쪽 자식, 오른쪽 자식, 루트
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int treeSize = Integer.parseInt(br.readLine());
        String[] buildArray = new String[treeSize*3+1];
        for (int i = 0; i < treeSize; i++) {
			String[] split = br.readLine().split(" ");
		}
		
	}

}
