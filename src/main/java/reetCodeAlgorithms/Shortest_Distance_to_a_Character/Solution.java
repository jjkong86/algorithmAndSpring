package reetCodeAlgorithms.Shortest_Distance_to_a_Character;

class Solution {
    public int[] shortestToChar(String S, char C) {
        // 주어진 문자열에서 문자 c의 최단 거리를 나타내는 정수 배열을 반환
        
        char[] chars = S.toCharArray();
        int len = chars.length;
        int[] ret = new int[len];
        int left = -1;
        int right = len + 1;
        for (int i=0; i<len; i++) {
            if (C == chars[i]) {
                if (left == -1) {
                    left = i;
                    for (int j=0; j<=i; j++) {
                        ret[j] = Math.abs(j-i);
                    }
                } else {
                    if (right == len +1) {
                        right = i;
                    } else {
                        int temp = right;
                        right = i;
                        left = temp;
                    }
                    
                    for (int j=left+1; j<=right; j++) {
                        ret[j] = Math.min(Math.abs(j-left), Math.abs(j-right));
                    }
                }
            }
        }
        if (right == len +1) {
            for (int i=left+1; i<len; i++) {
                ret[i] = Math.abs(left - i);
            }
        } else {
            for (int i=right+1; i<len; i++) {
                ret[i] = Math.abs(right - i);
            }
        }
        
        return ret;
    }
    
    public int[] shortestToChar2(String S, char C) {
		char[] chars = S.toCharArray();
		int len = chars.length;
		int[] ret = new int[len];
    	int index = ret.length-1;
		
		for (int i = 0; i < ret.length; i++) {
			if (C == ret[i]) index = i;
			ret[i] = Math.abs(index - i);
		}
		
		index = 0;
		for (int i = index; i > 0; i--) {
			if (C == ret[i]) index = i;
			ret[i] = Math.min(ret[i], Math.abs(i - index));
		}
    	return ret;
    }
}
