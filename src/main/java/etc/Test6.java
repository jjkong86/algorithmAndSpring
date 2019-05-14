package etc;

public class Test6 {
	public static void main(String[] args) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int indexI = (i/3)*3 + j/3;
				int indexJ = (i*3)%9 + j%3;
                System.out.println("indexI : "+indexI + ", indexJ : "+indexJ);
			}
			System.out.println("===============================");
		}
	}
}
