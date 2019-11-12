package test.socar;

import java.util.Arrays;
import java.util.Random;
import java.util.StringJoiner;

/*
 * 지뢰의 값은 -1로 함.
 * 완전 탐색하여 지뢰를 찾고,
 * 지뢰주위의 8방향의 좌표를 미리 만들어놓고(coordinates) 반복문을 통해서 숫자를 +1 해줌
 * */
public class Solution {
	static int[][] array = new int[10][10];
	static int[][] coordinates = new int[9][2];

	public static int[][] solution() {
		makeMine();
		makeCoordinates();

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] == -1) {
					for (int k = 0; k < coordinates.length; k++) { // 지뢰 주위의 8방향을 찾아서 +1 해줌
						int x = j + coordinates[k][1];
						int y = i + coordinates[k][0];
						if (outOfIndexChk(x, y) && array[y][x] != -1) {
							array[y][x] += 1;
						}
					}
				}
			}
		}

		return array;
	}

	private static boolean outOfIndexChk(int x, int y) {
		return x >= 0 && x < array[0].length && y >= 0 && y < array.length;
	}

	private static void makeMine() {
		Random ran = new Random();
		for (int i = 0; i < 10; i++) {
			int x = ran.nextInt(10);
			int y = ran.nextInt(10);
			if (array[y][x] != -1) { // 지뢰 세팅 중 중복 좌표로 들어오는것을 방지
				array[y][x] = -1;
			} else {
				--i;
			}
		}
	}

	private static void makeCoordinates() {
		int index = 0;
		for (int i = 2; i >= 0; i--) {
			for (int j = 2; j >= 0; j--) {
				coordinates[index][0] = 1 - i;
				coordinates[index++][1] = 1 - j;
			}
		}
	}

	public static void main(String[] args) {
		solution();

		StringJoiner sj = new StringJoiner("\n");
		for (int[] is : array) {
			sj.add(Arrays.toString(is));
		}
		System.out.println(sj.toString());
	}
}
