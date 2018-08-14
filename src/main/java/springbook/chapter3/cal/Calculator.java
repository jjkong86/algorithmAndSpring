package springbook.chapter3.cal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {
	public Integer calcSum(String filepath) throws IOException {

		LineCallback<Integer> callback = new LineCallback<Integer>() {
			
			@Override
			public Integer doSumethingWithLine(String line, Integer value) {				
				return value += Integer.valueOf(line);
			}
		};
		return lineReadTemplate(filepath, callback, 0);
		
		
	}
	
	public String concatenate(String filepath) throws IOException {

		LineCallback<String> callback = new LineCallback<String>() {
			
			@Override
			public String doSumethingWithLine(String line, String value) {				
				return value += line;
			}
		};
		return lineReadTemplate(filepath, callback, "");
		
		
	}
	
	
	public Object calcMultiply(String filepath) throws IOException {

		LineCallback<Integer> callback = new LineCallback<Integer>() {			
			@Override
			public Integer doSumethingWithLine(String line, Integer value) {				
				return value *= Integer.valueOf(line);
			}
		};
		return lineReadTemplate(filepath, callback, 1);
	}

	public <T> T lineReadTemplate(String filepath, LineCallback<T> callback, T initVal) throws IOException {
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filepath));
			T res = initVal;
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
