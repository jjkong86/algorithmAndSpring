
public class Solution2 {

	
	public static void main(String[] args) {
		int num = 7;
		int count = 0;
		while(num != 0) {
			int temp = num/2;
			count += (num - temp*2) == 0 ? 0 : 1;
			num = temp;
		}
		System.out.println(count);
	}
	
}
