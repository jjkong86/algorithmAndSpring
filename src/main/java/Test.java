
public class Test {
	private final String str;
	
	Test(String str) {
		this.str = str;
	}
	
	public static void main(String[] args) {
		Integer a = 1;
		Integer b = null;
		System.out.println(a==b);
		int c =1;
		System.out.println(c==b);
	}
}
