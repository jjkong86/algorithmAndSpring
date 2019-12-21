package test;
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution1 {
	class Tree {
		public int x;
		public Tree l;
		public Tree r;
	}

	int count = 0;

	static class Pair<E1, E2> {
		E1 tree;
		E2 set;

		public Pair(E1 t, E2 hashSet) {
			this.tree = t;
			this.set = hashSet;
		}
	}

	public int solution(Tree T) {
		// write your code in Java SE 8
		// 중복값은 어떻게 체크??
		Queue<Pair<Tree, Set<Integer>>> q = new LinkedList<>();
		Set<Integer> set = new HashSet<>();
		set.add(T.x);
		count += 1;
		q.offer(new Pair<Tree, Set<Integer>>(T, set));

		while (!q.isEmpty()) {
			Pair<Tree, Set<Integer>> pair = q.poll();
			if (dupleChk(pair.tree.l, pair.set)) {
				offerQ(q, pair.tree.l, pair.set);
			}
			if (dupleChk(pair.tree.r, pair.set)) {
				offerQ(q, pair.tree.r, pair.set);
			}
		}
		return count;
	}

	public boolean dupleChk(Tree tree, Set<Integer> set) {
		return tree != null && !set.contains(tree.x);
	}

	public void offerQ(Queue<Pair<Tree, Set<Integer>>> q, Tree tree, Set<Integer> set) {
		Set<Integer> tempSet = new HashSet<>(set);
		tempSet.add(tree.x);
		q.offer(new Pair<Tree, Set<Integer>>(tree, tempSet));

		count = Math.max(count, tempSet.size());
	}
}
