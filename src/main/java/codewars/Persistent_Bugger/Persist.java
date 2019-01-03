package codewars.Persistent_Bugger;

public class Persist {
	public static int persistence(long n) {
		// your code
		int count = 0;
		long temp = 1;
		if (n < 10) {
			return 0;
		}
		while (n > 0) {
			temp *= n%10;
			n = n/10;
		}
		count ++;
		
		if (temp > 10) {
			System.out.println(temp);
			count = persistence(temp, count);
		} else {
			return count;
		}
		System.out.println(count);
		return count;
	}
	
	public static int persistence(long n, int count) {
		long temp = 1;
		while (n > 0) {
			temp *= n%10;
			n = n/10;
		}
		count ++;
		
		if (temp > 10) {
			count = persistence(temp, count);
		} else {
			return count;
		}
		return count;
	}
}
