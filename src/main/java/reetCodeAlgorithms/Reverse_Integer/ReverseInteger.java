package reetCodeAlgorithms.Reverse_Integer;

public class ReverseInteger {
	public int reverse(int x) {
		int ret = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (ret > Integer.MAX_VALUE/10 || (ret == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (ret < Integer.MIN_VALUE/10 || (ret == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            ret = ret * 10 + pop;
        }
        return ret;
	}
	
	public static void main(String[] args) {
		int x = 1534236469;
		ReverseInteger r = new ReverseInteger();
		System.out.println(r.reverse(x));
	}
}
