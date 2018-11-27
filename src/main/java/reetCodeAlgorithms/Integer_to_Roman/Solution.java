package reetCodeAlgorithms.Integer_to_Roman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.fabric.xmlrpc.base.Array;

public class Solution {

	public String intToRoman(int num) {
		/*
			4는 IV
			int num -> /2, /5 두가지로 나뉨
			flag로 분기처리 필요
			문자 조합은 작은 수가 왼쪽
		 */
		if(num == 0) {
			return null;
		}
		
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "I");
		map.put(4, "IV");
		map.put(5, "V");
		map.put(9, "IX");
		map.put(10, "X");
		map.put(50, "L");
		map.put(100, "C");
		map.put(500, "D");
		map.put(1000, "M");
		
		if (map.get(num) != null) {
			return map.get(num);
		}
		
		String ret = "";
		int saveNum = 1000;
		while (num > 0) {
			int multiNum = (int)num / saveNum;
			
			if (multiNum == 9) {
				int tempSaveNum = saveNum * 10;
				ret += map.get(saveNum)+map.get(tempSaveNum);
			} else if (multiNum == 4) {
				int tempSaveNum = saveNum * 5;
				ret += map.get(saveNum)+map.get(tempSaveNum);
			} else if (multiNum >= 5) {
				int tempSaveNum = saveNum * 5;
				int lengthTemp = multiNum % 5;
				ret += map.get(tempSaveNum);
				for (int j = 0; j < lengthTemp; j++) {
					ret += map.get(saveNum);
				}
			}else {
				// 3 = III
				for (int j = 0; j < multiNum; j++) {
					ret += map.get(saveNum);
				}
			}
			num = num % saveNum;
			saveNum = saveNum / 10;
		}
		
		return ret;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.intToRoman(4));
//		System.out.println(1994%1000);
	}

}
