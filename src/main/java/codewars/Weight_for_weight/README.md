## 문제풀이
 1. Weight for weight
 2. 가중치는 각 자리들의 숫자를 더한값
 3. 가중치가 같다면 앞자리 부터 작은 수
 
		@Override
		public int compareTo(Weight w) {
			if (this.weight != w.weight) return Integer.compare(this.weight, w.weight);
			if (this.number.equals(w.number)) return 0;
			
			int thisLen = this.number.length();
			int wLen = w.number.length();
			int len = thisLen < wLen ? thisLen : wLen;
			for (int i = 0; i < len; i++) {
				char thisC = this.number.charAt(i);
				char wC = w.number.charAt(i);
				if (thisC == wC) continue;
				
				return Character.compare(thisC, wC);
			}
			return Integer.compare(thisLen, wLen);
		}

## Link
https://www.codewars.com/kata/55c6126177c9441a570000cc

## MyAccount

> backjoon : <https://www.acmicpc.net/user/jjkong86>  
> codewars : <https://www.codewars.com/users/jeongjeagong>  
> leetCode : <https://leetcode.com/jjkong86/>
