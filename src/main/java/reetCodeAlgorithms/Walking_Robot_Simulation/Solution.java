package reetCodeAlgorithms.Walking_Robot_Simulation;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

class Solution {
	int[][] direction = new int[][] { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
	int dIndex = 0;

	public int robotSim(int[] commands, int[][] obstacles) {
		int[] move = new int[2];
		int result = 0;

		Set<String> set = new HashSet<>();
		for (int[] obs : obstacles) {
			set.add(obs[0] + " " + obs[1]);
		}

		for (int num : commands) {
			if (num < 0) {
				directions(num);
			} else {
				while (num-- > 0
						&& !set.contains((move[0] + direction[dIndex][0]) + " " + (move[1] + direction[dIndex][1]))) {
					move[0] += direction[dIndex][0];
					move[1] += direction[dIndex][1];
				}
			}
			result = Math.max(result, makeSquare(move[0]) + makeSquare(move[1]));
		}
//        System.out.println(makeSquare(move[0]) + makeSquare(move[1]));
		return result;
	}

	public void directions(int num) {
		if (num == -2) {
			dIndex = (dIndex + 1) % direction.length;
		} else if (num == -1) {
			dIndex = (direction.length + dIndex - 1) % direction.length;
		}
	}

	public int makeSquare(int num) {
		num = Math.abs(num);
		return num * num;
	}

	public static class TestClass {
		@Test
		public void test1() {
			Solution s = new Solution();
			assertThat(65, is(s.robotSim(new int[] { 4, -1, 4, -2, 4 }, new int[][] { { 2, 4 } })));
		}

		@Test
		public void test2() {
			Solution s = new Solution();
			assertThat(4, is(s.robotSim(new int[] { 7, -2, -2, 7, 5 }, new int[][] { { -3, 2 }, { -2, 1 }, { 0, 1 },
					{ -2, 4 }, { -1, 0 }, { -2, -3 }, { 0, -3 }, { 4, 4 }, { -3, 3 }, { 2, 2 } })));
		}
	}
}
