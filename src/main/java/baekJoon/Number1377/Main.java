package baekJoon.Number1377;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringJoiner;

public class Main {
	/*
	 * 버블 정렬하여 정렬 횟수를 구하는 문제
	 * 시간 제한은 2초, 개수는 500,000개 이하 이므로 o(n2)방식으로는 시간 초과 하게됨
	 * 정렬 숫자는 최초 자리에서 앞으로 이동한 것 중 이동 횟수가 가장 많은 숫자를 구하면됨
	 * 숫자를 Pair 객체에 담아서 최초 위치한 index를 부여함
	 * 그리고 정렬 후의 index와 최초 부여된  index를 비교하여 가장 큰 수를 찾으면됨
	 * */
	public static class Pair {
		int index;
		int value;

		public Pair(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}

	public static int findAnswer(ArrayList<Pair> list) {
		Collections.sort(list, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				if (o1.value > o2.value) {
					return 1;
				} else if (o1.value == o2.value) {
					return 0;
				} else {
					return -1;
				}
			}
		});
		
		print(list);
		int max = 0;
		for (int i = 0; i < list.size(); i++) {
			if (max < list.get(i).index - i) {
				max = list.get(i).index - i;
			}
		}
		
		return max+1;
	}
	
	public static void print(ArrayList<Pair> list) {
		StringJoiner sj = new StringJoiner("\n");
		for (int i = 0; i < list.size(); i++) {
			StringBuilder sb = new StringBuilder();
			sb.append("index : "+list.get(i).index+", i : "+i+", value : "+list.get(i).value);
			sj.add(sb);
		}
		System.out.println(sj);
	}

	public static void main(String[] args) throws IOException, NumberFormatException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int number = Integer.parseInt(br.readLine());
			ArrayList<Pair> list = new ArrayList<Pair>();
			for (int i = 0; i < number; i++) {
				list.add(new Pair(i, Integer.parseInt(br.readLine())));
			}
			System.out.println(findAnswer(list));
		}
	}
}
