import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Test9 {
	
	public static int minPathTrace(int[][] array) {
		int len = array.length;
		int[] find1 = new int[] {0, 1, 0, -1};
		int[] find2 = new int[] {1, 0, -1, 0};
		boolean[][] flag = new boolean[len][len];
		flag[0][0] = true;
		Queue<String> queue = new LinkedList<>();
		queue.add("0 0");
		while (!queue.isEmpty()) {
			String[] str = queue.poll().split(" ");
			int num1 = Integer.parseInt(str[0]);
			int num2 = Integer.parseInt(str[1]);
			loop : for (int i = 0; i < 4; i++) {
				int x = num1 + find1[i];
				int y = num2 + find2[i];
				if (x >= 0 && y >= 0 && x < len && y < len) {
					if (array[x][y] == 0 || flag[x][y] == true) continue loop;
					array[x][y] = array[num1][num2] + 1;
					flag[x][y] = true;
					queue.add(x + " " + y);
				}
			}
		}
		
		return array[len-1][len-1]-1;
	}
	
	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int num = Integer.parseInt(br.readLine());
			int[][] array = new int[num][num];
			for (int i = 0; i < num; i++) {
				char[] chars = br.readLine().toCharArray();
				for (int j = 0; j < chars.length; j++) {
					array[i][j] = Character.getNumericValue(chars[j]);
				}
			}
			
			try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
				bw.write(String.valueOf(minPathTrace(array)));
			}
		}
	}
}
