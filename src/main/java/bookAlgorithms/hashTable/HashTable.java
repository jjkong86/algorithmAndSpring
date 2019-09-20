package bookAlgorithms.hashTable;

import java.util.Arrays;
import java.util.StringJoiner;

public class HashTable {
	
	static MapEntry[] hashTable;
	
	static class MapEntry<K, V> {
		K key;
		Node<V> Node;
		int childrenCount;
		MapEntry(K key, Node<V> node, int childrenCount) {
			this.key = key;
			this.Node = node;
			this.childrenCount = childrenCount;
		}
	}
	
	static class Node<V> {
		V val;
		Node<V> nextNode;
		
		Node(V val) {
			this.val = val;
		}
	}
	
	public static <K, V> void buildHashTable(Object[] array) {
		//해시값은 값들을 배열의 크기로 나눈 나머지로함
		//해시테이블은 노드의 배열로 구성하여 중복된 해시 값이 발생하면 노드를 연결하여 넣는다(같은 해시에서 마지막에 들어오는 수가 앞으로 감)
		int len = array.length;
		hashTable = new MapEntry[len];
		
		for (int i = 0; i < len; i++) {
			Object o = (Object)array[i];
			int hash = o.hashCode()%len;
			MapEntry<K, V> tempEntry = hashTable[hash];
			if (tempEntry != null) {
				Node<V> node = new Node((V)array[i]);
//				System.out.println(hash +" : index -> val : "+tempNode.val +", 추가됨 : "+node.val);
				node.nextNode = tempEntry.Node;
				hashTable[hash].Node = node;
				tempEntry.childrenCount += 1; 
			} else {
				hashTable[hash] = (MapEntry<K, V>)new MapEntry(hash, new Node((V)array[i]), 1);
			}
		}
	}
	
	public static <K, V> int isExsitValueIndex(V val) {
		Object o = (Object)val;
		int hash = o.hashCode()%hashTable.length;
		MapEntry<K, V> entry = hashTable[hash];
		if (entry != null) {
			while (entry.Node != null) {
				if (entry.Node.val == val) {
					return hash;
				}
				entry.Node = entry.Node.nextNode;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Object[] array = {55, 13, 42, 70, 43, 44, 3, 94, 47, 72, 39, 86, 76, 40};
		buildHashTable(array);
		int index = isExsitValueIndex(1);
		System.out.println("find value index : "+(index == -1 ? "찾는 숫자는 없음" : index));
		System.out.println(Arrays.toString(hashTable));
		printHash();
	}
	
	public static void printHash() {
		StringJoiner sj = new StringJoiner("\n");
		for (int i = 0; i < hashTable.length; i++) {
			MapEntry entry = hashTable[i];
			while (entry != null && entry.Node != null) {
				sj.add("hashKey : "+entry.key+", value : "+entry.Node.val+", childrenCount : "+entry.childrenCount);
				entry.Node = entry.Node.nextNode;
			}
		}
		System.out.println(sj);
	}
}
