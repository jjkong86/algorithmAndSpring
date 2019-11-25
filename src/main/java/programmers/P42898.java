package programmers;

class P42898 {
	int ho;
	int ver;
	final static int MAX_NUM = 1_000_000_007;

	public int solution(int m, int n, int[][] puddles) {
		ho = m - 1;
		ver = n - 1;
		int[][] array = new int[m][n];
		for (int i = 0; i < puddles.length; i++) {
			array[puddles[i][0] - 1][puddles[i][1] - 1] = 1;
		}
		return findPath(0, 0, array);
	}

	private int findPath(int x, int y, int[][] array) {
		if (x == ho && y == ver)
			return 1;

		int result = 0;
		if (outOfIndexChk(x + 1, 1) && array[x + 1][y] != 1) {
			result = (result + findPath(x + 1, y, array))%MAX_NUM;
		}

		if (outOfIndexChk(x, y + 1) && array[x][y + 1] != 1) {
			result = (result + findPath(x, y+1, array))%MAX_NUM;
		}
		return result;
	}

	private boolean outOfIndexChk(int x, int y) {
		return x <= ho && y <= ver;
	}
	
	public static void main(String[] args) {
		P42898 p = new P42898();
		System.out.println(p.solution(4, 3, new int[][] {{2,2}}));
	}
}
