## 문제풀이
 1. 다이나믹 프로그래밍 문제
 2. 3잔 연속은 안되기 때문에 경우의 수를 고려해 봐야함
 3. n의 범위는 1<= n <= 10,000 : 최소값과 최대값을 고려하여야함(예외처리)
 
> ```
> oox, oxo, xoo -> x가 나오는 시점의 dp[i-1]을 더해주고 고려한다
> oox : dp[i-1]
> oxo : dp[i-2] + array[i]
> xoo : dp[i-3] + array[i-1] + array[i]
> ```

## Link
https://www.acmicpc.net/problem/2156

## MyAccount

> backjoon : <https://www.acmicpc.net/user/jjkong86>  
> leetCode : <https://leetcode.com/jjkong86/> 



