package codewars.Find_the_odd_int;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindOdd {
	public static int findIt(int[] array) {
		// 주어진 배열에서 홀수번 반복되는 숫자를 찾는 문제인듯
		// xor 연산을 하면 clever : 홀수번 반복되는 숫자가 오직 하나 이기 때문에 xor 연산을 하면 짝수 숫자들은 모두 0이 되버림.. ex ) xor ^= array[i]
		Map<Integer, Integer> hMap = new HashMap<>();
		IntStream.of(array).forEach(i -> hMap.put(i, !hMap.containsKey(i) ? 1 : hMap.get(i) + 1));
		List<Integer> list = new ArrayList<>(hMap.keySet());
		return (int) list.stream().filter(i -> hMap.get(i) % 2 != 0).toArray()[0];
	}
}
