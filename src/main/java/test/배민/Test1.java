package test.배민;

public class Test1 {
	public static String solution(int U, int L, int[] C) {
		// write your code in Java SE 8
		// 합계가 불가능하면 "IMPOSSIBLE" 출력해야함
		// 답이 여러개이면 그 중 하나 반환
		String ip = "IMPOSSIBLE";

		StringBuilder sbU = new StringBuilder();
		StringBuilder sbL = new StringBuilder();
		for (int i = 0; i < C.length; i++) {
			int num = C[i];
			if (num == 0) {
				sbU.append("0");
				sbL.append("0");
			} else if (num == 2) {
				if (L == 0 || U == 0)
					return ip;
				sbU.append("1");
				sbL.append("1");
				U--;
				L--;
			} else {
				if (U > 0) {
					sbU.append("1");
					sbL.append("0");
					U--;
				} else if (L > 0) {
					sbU.append("0");
					sbL.append("1");
					L--;
				} else {
					return ip;
				}
			}
		}

		sbU.append(",").append(sbL);
		return sbU.toString();
	}

	public static void main(String[] args) {
		System.out.println(solution(3, 2, new int[] { 2, 1, 1, 0, 1 }));
		System.out.println(solution(2, 3, new int[] { 0, 0, 1, 1, 2 }));
		System.out.println(solution(0, 0, new int[] { 0 }));
	}
}
