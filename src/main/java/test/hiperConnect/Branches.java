package test.hiperConnect;

import java.util.HashMap;
import java.util.Map;

public class Branches {
	static Map<Integer, Integer> map = new HashMap<>();
	
    public static int count(int[] tree) {
    	if (tree == null) return 0;
    	int count = 0;
    	for (int i = 0; i < tree.length; i++) {
    		if (tree[i] == -1) continue;
    		int temp = countNode(tree, tree[i]);
    		map.put(i, temp);
    		count = Math.max(count, temp);
		}
    	return count;
    }

	private static int countNode(int[] tree, int target) {
		int count = 0;
		while (true) {
			count++;
			target = tree[target];
			if (target == -1) break;
			if (map.containsKey(target)) return count + map.get(target);
		}
		return count;
	}

	public static void main(String[] args) {
        System.out.println(Branches.count(new int[] { 1, 3, 1, -1, 3 }));
    }
}
