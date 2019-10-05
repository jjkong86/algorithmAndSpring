package test.십일번가;

public class Test1 {
	
	public int solution(int A, int B) {
        // write your code in Java SE 8
        // a * b -> 이진수로 변환하여 1의 개수를 리턴
        
        int mul = A * B;
        int count = 0;
        while(mul != 0) {
			count += mul%2 == 0 ? 0 : 1;
			mul /= 2;
		}
	    return count;	
    }
	
	public static void main(String[] args) {
		int a = 3;
		int c = 7;
		int b = a*c;
		int count = 0;
		while(b != 0) {
			count += b%2 == 0 ? 0 : 1;
			b /= 2;
		}
		System.out.println(count);
	}
}
