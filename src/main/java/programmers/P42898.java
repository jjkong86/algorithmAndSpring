package programmers;

class P42898 {
	final static int MAX_NUM = 1_000_000_007;

	public int solution(int m1, int n1, int[][] puddles) {
		int m = m1 + 1, n = n1+1;
		int[][] array = new int[m][n];
		for (int i = 0; i < puddles.length; i++) {
			array[puddles[i][0]][puddles[i][1]] = -1;
		}
		array[1][0] = 1;
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (array[i][j] == -1) {
					array[i][j] = 0;
				} else {
					array[i][j] = (array[i-1][j] + array[i][j-1])%MAX_NUM;
				}
			}
		}
		return array[m1][n1];
	}
	public static void main(String[] args) {
		P42898 p = new P42898();
		System.out.println(p.solution(4, 3, new int[][] {{2,2}}));
	}
}
