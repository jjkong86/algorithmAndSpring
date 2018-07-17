package springbook.dao.chapter3.cal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {
	public Integer calcSum(String filepath ) throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filepath));
			Integer sum = 0;
			String line = null;
			while((line = br.readLine()) != null) {
				sum += Integer .valueOf (line);
			}
			return sum;
		} catch (IOException e) {
			throw e;
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e2) {
					System.out.println(e2.getMessage());}
			}
		}
	}
}
