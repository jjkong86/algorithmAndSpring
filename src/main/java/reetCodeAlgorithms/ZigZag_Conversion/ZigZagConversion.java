package reetCodeAlgorithms.ZigZag_Conversion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZigZagConversion {
	
	public String convert(String s, int numRows) {
		/*
		numRows크기 많큼 문자열을 끊어서 저장
		String s보다 numRows가 크면 고려?
		string : sundayfriday numsRows : 3
		                       2n-1                                                               
                                1     2     3      2     1      2     3      2     1     2     3
		s   a   i               s     u     n      d     a      y     f      r     i     d     a        
		u d y r d y       =>> (0,0),(1,0),(2,0)//(1,1),(0,2)//(1,2),(2,2)//(1,3),(0,4)//
		n   f   a
		 */
		//i%3
		//0 > 0, 1 > 1, 2 > 2, 3 > 0, 4 > 1, 5 > 2
		
		if(numRows < 2) {
			return s;
		}
		
		List<StringBuilder> list = new ArrayList<>();
		for (int i = 0; i < Math.min(s.length(), numRows); i++) {
			list.add(new StringBuilder());
		}
		
		boolean flag = false;
		int count = 0;
		for (char c : s.toCharArray()) {
			list.get(count).append(c);
			if(count == 0 || count == numRows-1) {
				flag = !flag;
			}
			count += flag ? 1 : -1;
		}
		StringBuilder ret = new StringBuilder();
		String retStr = "";
		for (StringBuilder str : list) {
			ret.append(str);
		}
		retStr = String.valueOf(ret);
		return retStr;
		
	}
	public static void main(String[] args) {
		ZigZagConversion z = new ZigZagConversion();
		String result = z.convert("A", 10);
		if("PINALSIGYAHRPI".equals(result)) {
			System.out.println("성공");
		}
		System.out.println(result);
	}

}
