package bookAlgorithms.dynamicPrograming;

import java.util.Random;

public class MatrixPath {
	public static int[][] matrixPath(int[][] array) {
		//오른쪽이나 아래쪽으로만 이동할 수 있다.
		//왼쪽, 위쪽, 대각선 이동은 허용하지 않는다.
		//배열에 올 수 있는 최대값을 채워나감, 그리고 그 경로를 저장함
		
		return array;
	}
	
	public static void main(String[] args) {
		int num1 = 5;
		int num2 = 4;
		int[][] array = new int[num1][num2];
		Random ran = new Random();
		for (int i = 0; i < num1; i++) {
			for (int j = 0; j < num2; j++) {
				array[i][j] = ran.nextInt(100);
			}
		}
		System.out.println(matrixPath(array));
	}
}
