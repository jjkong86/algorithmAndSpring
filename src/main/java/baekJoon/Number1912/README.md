## 문제풀이
 1. n개의 정수로 이루어진 임의의 수열이 주어진다. 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합
 2. 연속 되어야 하고, 1개이상
 3. 하나씩 더해서 1보다 크면 계속 더해감, 0보다 작으면 dp에 들어온 숫자를 넣어준다.
 
> ```
if (dp[i - 1] > 0 ) {
	dp[i] = dp[i - 1] + array[i];
} else {
	dp[i] = array[i];
}
> ```

## 예제 입력
10
10 -4 3 1 5 6 -35 12 21 -1

## Link
https://www.acmicpc.net/problem/1912

## MyAccount

> backjoon : <https://www.acmicpc.net/user/jjkong86>  
> leetCode : <https://leetcode.com/jjkong86/>
