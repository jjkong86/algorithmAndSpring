package springbook.dao.chapter3.cal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {
	public Integer calcSum(String filepath ) throws IOException {

/*		return fileReadTemplate(filepath, new BufferedReaderCallback() {
			@Override
			public Integer doSomethingWithReader(BufferedReader br) throws IOException {
				Integer sum = 0;
				String line = null;
				while((line = br.readLine()) != null) {
					sum += Integer.valueOf(line);
				}
				return sum;
			}
		});*/
		LineCallback callback = new LineCallback() {
			
			@Override
			public Integer doSumethingWithLine(String line, Integer value) {
				
				return value += Integer.valueOf(line);
			}
		};
		return lineReadTemplate(filepath, callback, 0);
		
		
	}
	
	public Object calclultiply(String filepath) throws IOException {
		
/*		return fileReadTemplate(filepath, new BufferedReaderCallback() {
			@Override
			public Integer doSomethingWithReader(BufferedReader br) throws IOException {
				Integer mul = 1;
				String line = null;
				while((line = br.readLine()) != null) {
					mul *= Integer.valueOf(line);
				}
				return mul;
			}
		});*/
		LineCallback callback = new LineCallback() {
			
			@Override
			public Integer doSumethingWithLine(String line, Integer value) {
				
				return value *= Integer.valueOf(line);
			}
		};
		return lineReadTemplate(filepath, callback, 1);
	}

	public Integer lineReadTemplate(String filepath, LineCallback callback, int initVal) throws IOException {
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filepath));
			Integer res = initVal;
			String line = null;
			while ((line = br.readLine()) != null) {
				res = callback.doSumethingWithLine(line, res);
			}
			return res;
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
	
	public Integer fileReadTemplate(String filepath, BufferedReaderCallback callback) throws IOException {
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filepath));
			int ret = callback.doSomethingWithReader(br);
			return ret;
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
