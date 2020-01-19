package etc.coupleMatching;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringJoiner;

public class CoupleMatching {
	String[] strs = null;
	boolean isMax = false;
	Map<String, List<Integer>> map = new HashMap<>();

	public String build(String fileName) {
		fileRead(fileName); // 파일을 읽어서 데이터를 담음

		if (isMax)
			return findToMap(map); // 문자열이 일치하여 map에서 값을 가져옴

		return findToArray();
	}

	private void fileRead(String fileName) {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			int peopleCount = Integer.parseInt(br.readLine());
			strs = new String[peopleCount];
			int index = 0;
			while (br.ready()) {
				String key = sortedString(br.readLine());
				int valueCount = buildMap(map, key, index + 2); // 문자열이 일치 하는 경우 사용하기 위해 map에 담아둠

				if (!isMax && valueCount > 1) { // 문자열이 일치 하여 map으로 사용하면 되기 때문에 배열 구성을 제외시킴
					isMax = true;
				} else if (!isMax) {
					strs[index] = key;
				}
				index++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String sortedString(String readLine) {
		char[] temp = readLine.replace(" ", "").toCharArray();
		Arrays.sort(temp);
		return String.valueOf(temp);
	}

	private int buildMap(Map<String, List<Integer>> map, String key, int index) {
		if (map.get(key) == null) {
			map.put(key, new ArrayList<>());
		}
		List<Integer> values = map.get(key);
		values.add(index);
		return values.size();
	}

	private String findToMap(Map<String, List<Integer>> map) {
		StringJoiner sj = new StringJoiner(", ");
		for (Entry<String, List<Integer>> entry : map.entrySet()) {
			List<Integer> list = entry.getValue();
			if (entry.getValue().size() > 1) { // map에서 정렬된 문자를 key로 index를 value로 넣어뒀기 때문에, 2개 이상일 때 같은 문자가 있다고 판단
				for (int i = 0; i < list.size(); i++) {
					for (int j = i + 1; j < list.size(); j++) {
						StringBuilder sb = new StringBuilder();
						sb.append(String.valueOf(list.get(i))).append("-").append(String.valueOf(list.get(j)));
						sj.add(sb.toString());
					}
				}
			}
		}
		return sj.toString();
	}

	private String findToArray() {
		int max = 0;
		StringJoiner sj = new StringJoiner("\n");
		for (int i = 0; i < strs.length; i++) {
			char[] left = strs[i].toCharArray();
			for (int j = i + 1; j < strs.length; j++) {
				char[] right = strs[j].toCharArray();
				int count = compair(left, right, max);

				if (count >= max) {
					if (count > max) {
						sj = new StringJoiner("\n"); // 기존에 찾은 문자열보다 일치 문자가 더 많기 때문에 초기화
						max = count;
					}
					StringBuilder sb = new StringBuilder();
					sb.append(String.valueOf(i + 2)).append("-").append(String.valueOf(j + 2));
					sj.add(sb.toString());
				}
			}
		}
		return sj.toString();
	}

	private int compair(char[] left, char[] right, int max) {
		int index = 0, count = 0;
		for (int i = 0; i < left.length && index < right.length; i++, index++) {
			if (left[i] == right[index]) {
				count++;
			} else if (left[i] > right[index]) { // 정렬이 되어 있기 때문에 불 일치 할 경우 작은 문자열만 오른쪽으로 이동
				i--;
			} else { // 정렬이 되어 있기 때문에 불 일치 할 경우 작은 문자열만 오른쪽으로 이동
				index--;
			}

			if (left.length - (Math.max(i, index) + 1) + count < max) { // 비교 뭄자열이 일치하는 개수보다 적을경우
				return 0;
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		String path = CoupleMatching.class.getResource("").getPath();
		String[] fileNames = new String[] { "100.txt", "10000.txt", "500000.txt" };
		for (String fileName : fileNames) {
			CoupleMatching c = new CoupleMatching();
			String result = c.build(path + fileName);
			System.out.println(result);
			System.out.println(path + "OUTPUT_" + fileName);
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(path + "OUTPUT_" + fileName))) {
				writer.write(result);
			}
		}
	}
}
