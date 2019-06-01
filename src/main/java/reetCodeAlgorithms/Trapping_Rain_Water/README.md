## 문제풀이
 1. Trapping Rain Water
 2. 물이 고이는 조건 : 두 수의 사이값이 작은 경우
 3. left, right 두부분 으로 나눔 -> left는 왼쪽을 벽으로 생각, right는 오른쪽을 벽으로 생각
 4. 작아지면 더하면됨

	if ( h[left] < h[right] ) {
		leftMaxHeight = Math.max(leftMaxHeight, h[++left]);
		totalArea += leftMaxHeight-h[left];
	} else {
	    rightMaxHeight = Math.max(rightMaxHeight, h[--right]);
	    totalArea += rightMaxHeight-h[right];
	}
 
## Link
https://leetcode.com/problems/trapping-rain-water/

## MyAccount

> backjoon : <https://www.acmicpc.net/user/jjkong86>  
> codewars : <https://www.codewars.com/users/jeongjeagong>  
> leetCode : <https://leetcode.com/jjkong86/>
