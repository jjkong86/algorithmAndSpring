## 문제풀이
 1. 타일 채우기 : 3*num 크기의 벽을 2*1, 1*2 크기의 타일로 채우는 경우의 수
 2. num이 홀수이면 비는칸이나 부족한 칸이 생기므로 2의 배수만 다 채울수 있다
 
> ```
> dp[n] = dp[n-2]*3 + 2*loop 
> ```

## 예제 입력
2

## Link
https://www.acmicpc.net/problem/2133

## MyAccount

> backjoon : <https://www.acmicpc.net/user/jjkong86>  
> leetCode : <https://leetcode.com/jjkong86/>
