## 문제풀이
 1. Word Break
 2. 문자열 s가 주어지면 wordDict의 단어들이 포함되는가?
 3. dp로 해결, set 이용
 
	 for (int i=1; i<=s.length(); i++) {
	            for(int j=0; j<i; j++) {
	                if (flag[j] && dict.contains(s.substring(j, i))) {
	                    flag[i] = true;
	                    break;
	                }
	            }
	}
 
## Link
https://leetcode.com/problems/word-break/

## MyAccount

> backjoon : <https://www.acmicpc.net/user/jjkong86>  
> codewars : <https://www.codewars.com/users/jeongjeagong>  
> leetCode : <https://leetcode.com/jjkong86/>
