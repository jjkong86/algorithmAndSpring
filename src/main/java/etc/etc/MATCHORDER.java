package etc.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MATCHORDER {
	// 어떻게 해야 최대 승수를 구할 수 있을까?
	// 지는 상황에서는 최대한 크게 지고, 이기는 상황에서는 최대한 작게 이기면?
	// 두 배열을 정렬하고 비교 해보면?
	
	public static String maxWin(List<int[][]> list) {
		StringBuilder sb = new StringBuilder();
		
		for (int[][] array : list) {
			int[] teamR = array[0];
			int[] teamK = array[1];
			Arrays.sort(teamR);
			Arrays.sort(teamK);
			
			int index = 0;
			int winCount = 0;
			for (int score : teamR) {
				while (index <  teamK.length) {
					if (teamK[index++] >= score) {
						winCount++;
						break;
					}
				}
			}
			sb.append(winCount+"\n");
		}
		return sb.toString();
	}
	
	
	
	public static int[] stringToInt(String[] strs) {
		return Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
	}
	
	public static void main(String[] args) throws IOException {
		String result = "";
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int roop = Integer.parseInt(br.readLine());
			List<int[][]> list = new ArrayList<>();
			for (int i = 0; i < roop; i++) {
				int len = Integer.parseInt(br.readLine());
				list.add(new int[][] {stringToInt(br.readLine().split(" ")), stringToInt(br.readLine().split(" "))});
			}
			result = maxWin(list);
		}
		
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
			bw.write(result);
		}
		
	}
}
