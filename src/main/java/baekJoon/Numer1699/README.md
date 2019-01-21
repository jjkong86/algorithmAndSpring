## 문제풀이
 1. 계단 오르기
 2. 연속된 세 개의 계단은 안됨 -> 2개까지만, 단 시작점 포함 x
 3. 마지막 도착 계단 무조건 밟아야함
 4. oxo, xoo, oox 3가지 경우의 수 --> oox는 안됨 -> ex 10 10 1 1 10 계단을 한번에 새개 올라가게됨
 
 
> ```
> int case1 = dp[i - 2] + array[i - 1];
> int case2 = dp[i - 3] + array[i - 2] + array[i - 1];
> dp[i] = Math.max(case1, case2);
> ```

## 예제 입력
6  
10
20
15
25
10
20

## Link
https://www.acmicpc.net/problem/2579

## MyAccount

> backjoon : <https://www.acmicpc.net/user/jjkong86>  
> leetCode : <https://leetcode.com/jjkong86/>
