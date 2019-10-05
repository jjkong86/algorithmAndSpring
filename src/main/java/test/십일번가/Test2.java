package test.십일번가;

public class Test2 {
	
	public static int solution(String S) {
        // write your code in Java SE 8
        int num = Integer.parseInt(S, 2);
        int count = 0;
        while (num != 0) {
            count ++;
            if (num % 2 == 0) {
              num /= 2;  
            } else {
                num --;                
            }
        }
        return count;
    }
	
	public static int solution1(String S) {
		// write your code in Java SE 8
		int count = 0;
		while (!S.equals("0") && !S.equals("")) {
			if (Integer.parseInt(S, 2) == 0) break;
			count++;
			String last = S.substring(S.length() - 1);
			if (Integer.parseInt(last) % 2 != 0) {
				if (Integer.parseInt(S.substring(0, S.length() - 1)) == 0) break;
				count++;
			}
			S = S.substring(0, S.length() - 1);
		}
		return count;
	}
	
	public static void main(String[] args) {
		String s = "011100";
		System.out.println(solution("1000000"));
	}
}
