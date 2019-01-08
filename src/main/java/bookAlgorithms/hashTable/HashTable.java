package bookAlgorithms.hashTable;

import java.util.StringJoiner;

public class HashTable {
	static class Node {
		int val;
		int childrenCount;
		Node nextNode;
		Node(int val, int c) {
			this.val = val;
			this.childrenCount = c;
			this.nextNode = null;
		}
	}
	
	public static Node[] buildHashTable(int[] arrays) {
		int len = arrays.length;
		Node[] hashTable = new Node[len];
		for (int i = 0; i < len; i++) {
			int hash = arrays[i]%13;
			Node tempNode = hashTable[hash];
			if (tempNode != null) {
				Node node = new Node(arrays[i], tempNode.childrenCount+1);
//				System.out.println(hash +" : index -> val : "+tempNode.val +", 추가됨 : "+node.val);
				node.nextNode = tempNode;
				hashTable[hash] = node;
			} else {
				hashTable[hash] = new Node(arrays[i], 1);
			}
		}
		return hashTable;
	}
	
	public static int isExsitValueIndex(Node[] hashTable, int val) {
		int hash = val%13;
		Node tempNode = hashTable[hash];
		
		if (tempNode == null) {
			return -1;
		} else {
			while (tempNode != null) {
				if (tempNode.val == val) {
					return hash;
				}
				tempNode = tempNode.nextNode;
			}
		}
		return hash;
	}
	
	public static void main(String[] args) {
		int[] arrays = {55, 13, 42, 70, 43, 44, 3, 94, 47, 72, 39, 86, 76, 40};
		Node[] hashTable = buildHashTable(arrays);
		int index = isExsitValueIndex(hashTable, 12);
		System.out.println("find value index : "+(index == -1 ? "찾는 숫자는 없음" : index));
		printHash(hashTable);
	}
	
	public static void printHash(Node[] hashTable) {
		StringJoiner sj = new StringJoiner("\n");
		for (int i = 0; i < hashTable.length; i++) {
			Node temp = hashTable[i];
			while (temp != null) {
				sj.add("hashIndex : "+i +", val : "+temp.val+", childrenCount : "+temp.childrenCount);
				temp = temp.nextNode;
			}
		}
		System.out.println(sj);
	}
}
