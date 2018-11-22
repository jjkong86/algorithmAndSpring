package algorithms.Reverse_Integer;

public class ReverseInteger {
	public int reverse(int x) {
		String ret = String.valueOf(x);
		ret = new StringBuilder(ret).reverse().toString();
		long retInt = 0L;
        if(x < 0) {
        	ret = ret.replace("-", "");
        	retInt = Long.valueOf(ret)*(-1);
        } else {
        	retInt = Long.valueOf(ret);
        }
		
		return (int) retInt;	
	}
	
	public static void main(String[] args) {
		int x = 2147483647;
		ReverseInteger r = new ReverseInteger();
		System.out.println(r.reverse(x));
	}
}
