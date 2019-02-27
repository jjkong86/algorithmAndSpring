package codewars.Find_the_odd_int;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class FindOdd {
	public static int findIt(int[] array) {
		// 주어진 배열에서 홀수번 반복되는 숫자를 찾는 문제인듯
		Map<Integer, Integer> hMap = new HashMap<>();
		IntStream.of(array).forEach(i -> hMap.put(i, hMap.get(i) == null ? 1 : hMap.get(i) + 1));
		List<Integer> list = new ArrayList<>(hMap.keySet());
		return (int) list.stream().filter(i -> hMap.get(i) % 2 != 0).toArray()[0];
	}
}
