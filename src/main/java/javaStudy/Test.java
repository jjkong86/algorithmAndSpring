package javaStudy;

public class Test {
	public static void main(String[] args) {
		String str = "";
		long time = System.currentTimeMillis();
		for (int j = 0; j < 10000; j++) {
			str += "some string";
		}
		System.out.println((System.currentTimeMillis() - time));

		time = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < 1000000; j++) {
			sb.append("some string");
		}
		System.out.println((System.currentTimeMillis() - time));
		
		time = System.currentTimeMillis();
		StringBuffer sb1 = new StringBuffer();
		for (int j = 0; j < 1000000; j++) {
			sb1.append("some string");
		}
		System.out.println((System.currentTimeMillis() - time));
	}
}
