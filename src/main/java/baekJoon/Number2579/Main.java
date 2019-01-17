package baekJoon.Number2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	public static int stairClimb(int[] array) {
		// 계단은 1단계, 2단계 오를 수 있다
		// 연속된 세 개의 계단은 안됨 -> 2개까지만, 단 시작점 포함 x
		// 마지막 도착 계단 무조건 밟아야함
		// ooxo, oxoo, xoox 3가지 경우의 수인듯?
		
		
		return 0;
	}

	public static void main(String[] a) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		br.close();
	}

}
