package springbook.chapter6.learningTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ewfwefwe {
	
	public static void main(String[] args) {
		String email = "jjkong86@";
		System.out.println(email.split("@").length);
		
		String frnrDvCd = "2";
		String chkKycRegInfo = "ㄹㄹ";
		Map<String, Object> mmbInfo = new HashMap<>();
		mmbInfo.put("gett", "gett");
		
//		String ivtnUunfyMmbNo = String.valueOf(mmbInfo.get("putt"));
		String ivtnUunfyMmbNo = mmbInfo.get("putt") == null ? "null" :String.valueOf(mmbInfo.get("putt"));
		System.out.println(ivtnUunfyMmbNo);
		if(ivtnUunfyMmbNo != "null" && !"".equals(ivtnUunfyMmbNo)) {
			System.out.println(ivtnUunfyMmbNo);
		}
		
		String test123 = null;
		
		for (int i = 0; i < 5; i++) {
			
			if(i < 2) {
				continue;
			}
			System.out.println(i);
		}
		
	}

}
