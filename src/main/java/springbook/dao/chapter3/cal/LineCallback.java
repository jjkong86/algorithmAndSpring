package springbook.dao.chapter3.cal;

import java.io.BufferedReader;

public interface LineCallback {
	Integer doSumethingWithLine(String line, Integer value);
}
