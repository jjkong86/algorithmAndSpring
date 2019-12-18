package reetCodeAlgorithms.문제미정;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution {
	static int max = 0;

	public static int solution(int n, int[][] edge) {
		for (int[] is : edge) {
			Arrays.sort(is);
		}
		Arrays.sort(edge, Comparator.comparing(e -> e[0]));
		Map<Integer, List<Integer>> map = buildMap(edge);

		int[] counts = new int[max + 1];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { edge[0][0], 0 });

		while (!q.isEmpty()) {
			int[] array = q.poll();
			int currentCount = array[1];
			if (counts[array[0]] != 0) {
				counts[array[0]] = Math.min(counts[array[0]], currentCount + 1);
			} else {
				counts[array[0]] = currentCount + 1;
			}

			List<Integer> list = map.get(array[0]);
			if (list == null || list.isEmpty())
				continue;

			for (int num : list) {
				q.offer(new int[] { num, currentCount + 1 });
			}
		}

		System.out.println(Arrays.toString(counts));
		return (int) Arrays.stream(counts).filter(e -> e == n).count();
	}

	private static Map<Integer, List<Integer>> buildMap(int[][] edge) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int[] is : edge) {
			int key = is[0];
			if (map.get(key) == null) {
				map.put(key, new ArrayList<>());
			}
			map.get(key).add(is[1]);
			max = Math.max(max, is[1]);
		}
		return map;
	}

	public static void main(String[] args) {
		System.out.println(solution(3, new int[][] { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 } }));
	}
}
