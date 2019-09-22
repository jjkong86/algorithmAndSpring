package etc.hiperConnect;

public class Branches {
	
    public static int count(int[] tree) {
    	int count = 0;
    	for (int i = 0; i < tree.length; i++) {
    		if (tree[i] == -1) continue;
    		int temp = countNode(tree, tree[i]);
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
		}
		return count;
	}

	public static void main(String[] args) {
        System.out.println(Branches.count(new int[] { 1, 3, 1, -1, 3 }));
    }
}
