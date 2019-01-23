package baekJoon.Number1152;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine().trim();
		if (input.equals("")) {
			System.out.println(0);
		} else {
			System.out.println(input.split(" ").length);
		}
		br.close();
	}
}
