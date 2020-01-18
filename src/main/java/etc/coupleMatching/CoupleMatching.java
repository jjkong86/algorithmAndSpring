package etc.coupleMatching;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

// 문자열 2차 배열이 주어지고, 일치율이 가장 높거나 같은 문자열의 인덱스를 출력
// [abcd], [bcae], [aecg], [bcdt] -> [1,2], [1,4] 
public class CoupleMatching {
	static String path = CoupleMatching.class.getResource("").getPath();
	static final String NAME_10 = path + "10.txt";
	static final String NAME_100 = path + "100.txt";
	static final String NAME_10000 = path + "10000.txt";
	static final String NAME_500000 = path + "500000.txt";

	public static String build1() {
		// StringJoiner sj = new StringJoiner("\n");
		List<String> result = new ArrayList<>();
		String[] strs = null;
		try (BufferedReader br = new BufferedReader(new FileReader(NAME_10000))) {
			int peopleCount = Integer.parseInt(br.readLine());
			strs = new String[peopleCount];
			int index = 0;
			while (br.ready()) {
				char[] temp = br.readLine().replace(" ", "").toCharArray();
				Arrays.sort(temp);
				String key = String.valueOf(temp);
				strs[index++] = key;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		int max = 0;
		for (int i = 0; i < strs.length; i++) {
			char[] chars = strs[i].toCharArray();
			for (int j = i + 1; j < strs.length; j++) {
				char[] tempChars = strs[j].toCharArray();
				int count = 0;
				for (int t = 0; t < chars.length; t++) {
					if (chars[t] == tempChars[t]) {
						count++;
					}

					if (10 - t + (count - 1) < max) {
						break;
					}
				}

				if (count >= max) {
					if (count > max) {
						result.clear();
						max = count;
					}
					StringBuilder sb = new StringBuilder();
					sb.append(String.valueOf(i + 1)).append("-").append(String.valueOf(j + 1));
					result.add(sb.toString());
				}
			}
		}

		return String.valueOf(result.size());
	}

	public static String build2() {
		// StringJoiner sj = new StringJoiner("\n");
		List<String> result = new ArrayList<>();
		String[] strs = null;
		boolean isMax = false;
		Map<String, List<Integer>> map = new HashMap<>();
		try (BufferedReader br = new BufferedReader(new FileReader(NAME_500000))) {
			int peopleCount = Integer.parseInt(br.readLine());
			strs = new String[peopleCount];
			int index = 0;
			while (br.ready()) {
				char[] temp = br.readLine().replace(" ", "").toCharArray();
				Arrays.sort(temp);
				String key = String.valueOf(temp);
				if (map.get(key) == null) {
					map.put(key, new ArrayList<>());
				}
				List<Integer> values = map.get(key);
				values.add(index);
				if (!isMax && values.size() > 1) {
					isMax = true;
				} else if (!isMax) {
					strs[index++] = key;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (isMax)
			return findToMap(map);

		int max = 0;
		for (int i = 0; i < strs.length; i++) {
			char[] chars = strs[i].toCharArray();
			for (int j = i + 1; j < strs.length; j++) {
				char[] tempChars = strs[j].toCharArray();
				int count = 0;
				for (int t = 0; t < chars.length; t++) {
					if (chars[t] == tempChars[t]) {
						count++;
					}

					if (10 - t + (count - 1) < max) {
						break;
					}
				}

				if (count >= max) {
					if (count > max) {
						result.clear();
						max = count;
					}
					StringBuilder sb = new StringBuilder();
					sb.append(String.valueOf(i + 1)).append("-").append(String.valueOf(j + 1));
					result.add(sb.toString());
				}
			}
		}

		return String.valueOf(result.size());
	}

	private static String findToMap(Map<String, List<Integer>> map) {
		List<String> result = new ArrayList<>();
		for (Entry<String, List<Integer>> entry : map.entrySet()) {
			List<Integer> list = entry.getValue();
			if (entry.getValue().size() > 1) {
				for (int i = 0; i < list.size(); i++) {
					for (int j = i + 1; j < list.size(); j++) {
						StringBuilder sb = new StringBuilder();
						sb.append(String.valueOf(list.get(i))).append("-").append(String.valueOf(list.get(j)));
						result.add(sb.toString());
					}
				}
			}
		}
		return String.valueOf(result.size());
	}

	public static String build3() {
		// 정렬 안된 문자열을 배열로 만들고, 정렬된 문자열을 key로, 정렬했을 때 같은 문자들의 index를 배열로..
		List<String> result = new ArrayList<>();
		Map<String, List<Integer>> map = new HashMap<>();
		try (BufferedReader br = new BufferedReader(new FileReader(NAME_500000))) {
			br.readLine();
			// StringJoiner sj = new StringJoiner("\n");
			int index = 1;
			while (br.ready()) {
				char[] temp = br.readLine().replace(" ", "").toCharArray();
				Arrays.sort(temp);
				String key = String.valueOf(temp);
				if (map.get(key) == null) {
					map.put(key, new ArrayList<>());
				}
				map.get(key).add(index++);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (Entry<String, List<Integer>> entry : map.entrySet()) {
			List<Integer> list = entry.getValue();
			if (entry.getValue().size() > 1) {
				for (int i = 0; i < list.size(); i++) {
					for (int j = i + 1; j < list.size(); j++) {
						StringBuilder sb = new StringBuilder();
						sb.append(String.valueOf(list.get(i))).append("-").append(String.valueOf(list.get(j)));
						// sj.add(sb);
						result.add(String.valueOf(sb));
					}
				}
			}
		}

		return String.valueOf(result.size());
	}

	public static boolean stringEmptyChk(String str) {
		return str != null && !"".equals(str);
	}

	public static void main(String[] args) throws IOException {
		 long start1 = System.currentTimeMillis();
		 System.out.println(CoupleMatching.build1());
		 System.out.println((System.currentTimeMillis() - start1) / 1000.0);
		 System.out.println("==============================================");
		
		 long start2 = System.currentTimeMillis();
		 System.out.println(CoupleMatching.build2());
		 System.out.println((System.currentTimeMillis() - start2) / 1000.0);
		 System.out.println("==============================================");
		
		 long start3 = System.currentTimeMillis();
		 System.out.println(CoupleMatching.build3());
		 System.out.println((System.currentTimeMillis() - start3) / 1000.0);
	}
}
