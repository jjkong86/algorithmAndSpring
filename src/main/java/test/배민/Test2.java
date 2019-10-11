package test.배민;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.*;

import org.junit.Test;

class Test2 {
	Map<String, String[]> map;

	public String solution(String S) {
		// write your code in Java SE 8
		map = new LinkedHashMap<>();
		map.put("music", new String[] { ".mp3", ".aac", ".flac" });
		map.put("images", new String[] { ".jpg", ".bmp", ".gif" });
		map.put("movies", new String[] { ".mp4", ".avi", ".mkv" });
		map.put("other", new String[] {});

		String[] split = S.split("\n");
		Map<String, Integer> result = new HashMap<>();
		for (String str : split) {
			String res = findExtension(str);
			String space = str.split(" ")[1];
			result.put(res, result.getOrDefault(res, 0) + Integer.parseInt(space.substring(0, space.length() - 1)));
		}

		StringJoiner sj = new StringJoiner("\n");
		for (String str : map.keySet()) {
			StringBuilder sb = new StringBuilder();
			sb.append(str + " ");
			sb.append(result.getOrDefault(str, 0) + "b");
			sj.add(sb);
		}
		return sj.toString();
	}

	private String findExtension(String target) {
		for (Map.Entry<String, String[]> entry : map.entrySet()) {
			for (String str : entry.getValue()) {
				if (target.contains(str)) {
					return entry.getKey();
				}
			}
		}
		return "other";
	}

	// 시간 복잡도 개선
	public String solution2(String S) {
		String[] keys = new String[] { "music", "images", "movies", "other" };
		Map<String, Integer> map = makeMap();

		String[] split = S.split("\n");
		Map<String, Integer> result = new HashMap<>();
		for (String str : split) {
			String[] inner = str.split(" ");
			String[] nameAndExtension = inner[0].split("\\."); // 정규식 예약어 이기 때문
			String extention = "." + nameAndExtension[nameAndExtension.length - 1];
			String key = map.get(extention) == null ? "other" : keys[map.get(extention)];
			int space = Integer.parseInt(inner[1].replace("b", ""));

			result.put(key, result.getOrDefault(key, 0) + space);
		}

		StringJoiner sj = new StringJoiner("\n");
		for (String str : keys) {
			StringBuilder sb = new StringBuilder();
			sb.append(str + " ");
			sb.append(result.getOrDefault(str, 0) + "b");
			sj.add(sb);
		}
		return sj.toString();
	}

	private Map<String, Integer> makeMap() {
		Map<String, Integer> map = new HashMap<>();
		String[][] values = new String[][] { { ".mp3", ".aac", ".flac" }, { ".jpg", ".bmp", ".gif" },
				{ ".mp4", ".avi", ".mkv" } };
		for (int i = 0; i < values.length; i++) {
			for (String str : values[i]) {
				map.put(str, i);
			}
		}
		return map;
	}

	public static class TestClass {
		Test2 t = new Test2();

		@Test
		public void test1() {

			assertThat("music 1011b\n" + "images 0b\n" + "movies 10200b\n" + "other 105b", is(t.solution2(
					"my.song.mp3 11b\ngreatSong.flac 1000b\nnot3.txt 5b\nvideo.mp4 200b\ngame.exe 100b\nmov!e.mkv 10000b")));

		}
	}
}
