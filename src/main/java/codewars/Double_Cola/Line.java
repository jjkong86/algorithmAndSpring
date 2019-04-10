package codewars.Double_Cola;

public class Line {
	public static String WhoIsNext(String[] names, int n) {
		// Your code is here...
		// 선입선출로 줄을 서고 있음(1,2,3,4,5) -> pop -> 2,3,4,5,1,1 - > pop -> 3,4,5,1,1,2,2
		// 1 <= n <= 10000000000
		int index = 0;
		int len = names.length;
		int findIndex = 1;
		int prevIndex = index;
		while (index < n) {
			prevIndex = index;
			index += len*findIndex;
			findIndex *= 2;
		}
		findIndex /= 2;
		return names[((n-prevIndex -1)/findIndex)];
	}
}
